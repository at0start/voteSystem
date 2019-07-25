package newthread.votesystem.controller;

import newthread.votesystem.bean.Message;
import newthread.votesystem.bean.Project;
import newthread.votesystem.bean.Session;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author 一个糟老头子
 * @createDate 2019/7/17-15:30
 */
public class SessionController {


    //1.1.评审系统管理界面，检索的所有场次，前端会根据场次状态进行显示
    @RequestMapping("/getSessions")
    @ResponseBody
    public List<Session> getSessionStates() {
        List<Session> sessions = null;

        return sessions;
    }

    /**
     *  1.2.添加场次,默认前端场次状态添加1，即未开始
     * @param session
     * @return
     */
    @RequestMapping("/addSession")
    @ResponseBody
    public Session addSession(@RequestBody Session session) {
        //根据传入的评委数目n,默认赋予前n个评委投票权限
        return session;
    }

    //1.3.1.修改场次信息，先查询，再修改
    @RequestMapping("getSessionByID")
    @ResponseBody
    public Session getSessionByID(@RequestBody Integer sessionId){
        Session session = null;
        return  session;
    }
    //1.3.2 修改
    @RequestMapping("/updateSession")
    @ResponseBody
    public Session updateSession(@RequestBody Session session) {

        return session;
    }

    //1.4删除场次
    @RequestMapping("/deleteSession")
    @ResponseBody
    public Message deleteSession(@RequestBody Integer sessionId) {

        //如果评委数目改变时，修改评委权限（增加、减少评委）

        //返回一个message对象，是否删除成功（字符串）
        return null;
    }

    //1.5.1添加项目(前端将excel文件转换成project对象后传到controller)
    //如果后台
    @RequestMapping("/addProjects")
    @ResponseBody
    public List<Project> addProjects(@RequestBody List<Project> list) {

        //添加后做一次查询,问一下李返回所有项目还是刚刚添加的项目
        //或者批量插入重新获取本地项目，单次添加更新本地项目

        return null;
    }


    //导入项目（Excel）
    public List<Project> addProjects(@RequestBody String FilePath,Integer sessionId){
        return null ;
    }

    //手动添加

    public List<Project> addProject(@RequestBody Project project){

        return  null;
    }
    //1.5.2修改项目信息
    @RequestMapping("/updateProject")
    @ResponseBody
    public Project updateProject(@RequestBody Project project) {

        return project;
    }

    //1.5.3查询当前场次的项目
    private List<Project> getProjects(@RequestBody Integer sessionId){
        List<Project> projects = null;
        return projects;
    }

    //1.5.6上传项目文档
//    @RequestMapping("/upLoad")
//    @ResponseBody
//    public Message upLoad(RequestBody File file){
//
//        return file;
//    }

    //结束本场此
    public Message endSession(@RequestBody Integer sessinoId){

        Message message = null;
        return message;
    }
}
