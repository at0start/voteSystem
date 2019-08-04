package newthread.votesystem.controller;

import newthread.votesystem.bean.*;
import newthread.votesystem.bean.webBean.UserVoteInfo;
import newthread.votesystem.bean.webBean.VRound;
import newthread.votesystem.service.ProjectService;
import newthread.votesystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 一个糟老头子
 * @createDate 2019/7/17-15:36
 */
@Controller
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    ProjectService projectService;

    /**
     * 查询用户参与投票的轮次信息
     * @param user(userId)
     * @return 当前用户可以投票的轮次信息
     */
    @RequestMapping("/getUserVoteInfo")
    @ResponseBody
    public VRound getUserVoteInfo(@RequestBody User user){
        List<UserVoteInfo> list = userService.queryAll(user.getUserId());
        List<UserVoteInfo> before = new ArrayList<>();
        List<UserVoteInfo> being = new ArrayList<>();
        List<UserVoteInfo> after = new ArrayList<>();
        for (UserVoteInfo userVoteInfo:list) {
            if (userVoteInfo.getRoundState()==1){
                before.add(userVoteInfo);
            }else if (userVoteInfo.getRoundState()==2){
                being.add(userVoteInfo);
            }else {
                after.add(userVoteInfo);
            }
        }
        return new VRound(before,being,after);
    }

    /**
     * 获取该轮次下的所有项目
     * @param round (sessionId,roundId)
     * @return project
     */
    @RequestMapping("/getUserProjects")
    @ResponseBody
    public List<Project>  getUserProjects(@RequestBody Round round){

        return projectService.queryAllProjectsByRoundId(round.getSessionId(),round.getRoundId());
    }
    //2.1查看是否对当前场次有投票权限
    // SessionUser sessionUser

    /**
     * 查看是否有投票权限
     * @param sessionUser(sessionId userId)
     * @return boolean
     */
    @RequestMapping("/judgeAuthority")
    @ResponseBody
    public boolean judgeAuthority(@RequestBody SessionUser sessionUser){
        return userService.judgeAuthority(sessionUser.getUserId(),sessionUser.getSessionId()) ;
    }

    /**
     * 查看是否已经投票
     * 根据sessionId，round_order,projectId检索出result（list），
     * 判断其userId是否与传入的userId系相同
     * @param result(sessionId,roundId,userId)
     * @return  没有投票返回False
     */
    @RequestMapping("/judeVote")
    @ResponseBody
    public boolean judeVote(@RequestBody Result result){
        return userService.judeVote(result.getUserId(),result.getSessionId(),result.getRoundId()) ;
    }

    //下载项目文件
//    @RequestMapping("/getProjectFile")
//    @ResponseBody
//    public MultipartFile getProjectFile(@RequestBody Project project){
//
//
//        return  null;
//    }

    //提交投票结果
    @RequestMapping("/addResult")
    @ResponseBody
    public boolean addResult (@RequestBody List<Result> results){

        return  userService.addVoteResult(results);
    }




}
