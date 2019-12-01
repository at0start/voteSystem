package newthread.votesystem.controller;

import newthread.votesystem.bean.Project;
import newthread.votesystem.bean.Round;
import newthread.votesystem.bean.Session;
import newthread.votesystem.bean.webBean.Message;
import newthread.votesystem.bean.webBean.VSession;
import newthread.votesystem.service.ProjectService;
import newthread.votesystem.service.RoundService;
import newthread.votesystem.service.SessionService;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 一个糟老头子
 * @createDate 2019/7/17-15:30
 */
@Controller
public class SessionController {

    @Autowired
    SessionService sessionService;

    @Autowired
    ProjectService projectService;

    @Autowired
    RoundService roundService;

    /**
     * 评审系统管理界面，检索的所有场次，前端会根据场次状态进行显示
     * @return
     */
    @RequestMapping("/getSessions")
    @ResponseBody
    public VSession getSessions() {
        List<Session> sessions = sessionService.getAllSession();
        List<Session> before = new ArrayList<>();
        List<Session> being = new ArrayList<>();
        List<Session> after = new ArrayList<>();
        for (Session session: sessions) {
            if (session.getSessionState()==1){
                before.add(session);
            }else if (session.getSessionState()==2){
                being.add(session);
            }else {
                after.add(session);
            }
        }
        return new VSession(before,being,after);
    }

    /**
     *  1.2.添加场次,默认前端场次状态添加1，即未开始
     * @param session
     * @return
     */
    @RequestMapping("/addSession")
    @ResponseBody
    public Session addSession(@RequestBody Session session) {
        //将场次状态设为1
        session.setSessionState(1);
        //添加session
        Integer sessionId = sessionService.addSession(session);
        //将sessionId加入到返回的session对象
        Session session1 = sessionService.getSessionBySessionId(sessionId);
        //根据传入的评委数目n,默认赋予前n个评委投票权限
        sessionService.giveAuthority(session1.getSessionId());
        return session1;
    }

    /**
     *  修改场次信息，先查询，再修改
     * @param session(sessionId)
     * @return
     */
    @RequestMapping("/getSessionByID")
    @ResponseBody
    public Session getSessionByID(@RequestBody Session session){
        Session session1 =  sessionService.getSessionBySessionId(session.getSessionId());
        return session1;
    }

    /**
     *   修改场次信息
     * @param session
     * @return
     */
    @RequestMapping("updateSession")
    @ResponseBody
    public Session updateSession(@RequestBody Session session) {
        //修改场次信息
        boolean b = sessionService.updateSession(session);
        //如果评委数目改变时，修改评委权限（增加、减少评委）
        sessionService.giveAuthority(session.getSessionId());
            //返回修改后的场次信息
        if (b){
            return session;
        }else {
            return sessionService.getSessionBySessionId(session.getSessionId());
        }
    }


    /**
     *  删除场次
     * @param session（sessionId）
     * @return
     */
    @RequestMapping("/deleteSession")
    @ResponseBody
    public boolean deleteSession(@RequestBody Session session) {

        return sessionService.deleteBySessionId(session.getSessionId());
    }


    /**
     * 添加项目：导入项目（Excel）
     * @param //upLoadProject
     * @return
     * @throws IOException
     * @throws InvalidFormatException
     */
    @RequestMapping(value = "/addProjectsToSession",method = RequestMethod.POST,consumes =  "multipart/form-data")
    @ResponseBody
    public Message addProjectsToSession(@RequestParam(value = "sessionId",required = false) Integer sessionId
            , @RequestParam(value = "file",required = false) MultipartFile file) throws IOException, InvalidFormatException {

        Message message =new Message();
        try {
            //将file转换成File格式
            CommonsMultipartFile cf= (CommonsMultipartFile)file;
            DiskFileItem fi = (DiskFileItem)cf.getFileItem();
            File file1 = fi.getStoreLocation();
            //添加bean对象
            List<Project> list = projectService.uploadProject(file1,sessionId,file.getOriginalFilename());
            if (list.size()!=0)
                message.setMessage("上传成功");
        }catch (Exception e){
                message.setMessage("上传失败");
        }
        return message;
    }


    /**
     * 上传项目文档
     * @param //projectFile
     * @return
     */
    @RequestMapping(value = "/projectUpload",method = RequestMethod.POST,consumes =  "multipart/form-data")
    @ResponseBody
    public boolean projectUpload(@RequestParam(value = "file",required = false) MultipartFile file
            ,@RequestParam(value = "projectId",required = false) Integer projectId) throws IOException {
        String fileName = file.getOriginalFilename();
        System.out.println(fileName);
        CommonsMultipartFile cf= (CommonsMultipartFile)file;
        DiskFileItem fi = (DiskFileItem)cf.getFileItem();
        File file1 = fi.getStoreLocation();
        return projectService.uploadProjectFile(file1,projectId,fileName);
    }


    /**
     *  手动添加
     * @param project
     * @return
     */
    @RequestMapping("/addProjectToSession")
    @ResponseBody
    public List<Project> addProjectToSession(@RequestBody Project project){
        projectService.addProject(project);
        return  projectService.queryAllProject(project.getSessionId());
    }

    /**
     * 查询当前场次的所有项目
     * @param session (sessionId)
     * @return
     */
    @RequestMapping("/getSessionProjects")
    @ResponseBody
    private List<Project> getSessionProjects(@RequestBody Session session){
        return projectService.queryAllProject(session.getSessionId());
    }

    /**
     * 修改项目信息: 修改项目是在显示项目信息的
     *             基础上操作的所以不需要查询
     * @param project
     * @return
     */
    @RequestMapping("/updateSessionProject")
    @ResponseBody
    public Project updateSessionProject(@RequestBody Project project) {

        //利用主键删除，所一必须传入projectId
        projectService.updateProject(project);
        return projectService.queryProjectByProjectId(project.getProjectId());
    }

    /**
     * 结束本场此
     * @param session
     * @return
     */
    @RequestMapping("/endSession")
    @ResponseBody
    public boolean endSession(@RequestBody Session session){
        Session session1 = sessionService.getSessionBySessionId(session.getSessionId());
        session1.setSessionState(3);
        List<Round> rounds = roundService.queryAllRoundBySessionId(session.getSessionId());
        //结束当前场次下的所有轮次
        System.out.println(rounds.size());
        for (Round r : rounds) {
            if (r.getRoundState()!=3)
            roundService.endRound(session.getSessionId(),r.getRoundId());
        }
        return sessionService.updateSession(session1);
    }
}
