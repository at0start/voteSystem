package newthread.votesystem.controller;

import newthread.votesystem.bean.Message;
import newthread.votesystem.bean.Project;
import newthread.votesystem.bean.Result;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author 一个糟老头子
 * @createDate 2019/7/17-15:36
 */
public class UserController {

    //1.遍历当前用户可以投票的所有轮次
//    @RequestMapping("/getRounds")
//    @ResponseBody
//    public List<E> getRounds(@RequestBody String userId){
//        //1.1判断改评审员是否可以给本轮次投票（有权限，是否已经投票前端去判断）
//        List list = null;
//        return list;
//    }

    //2.投票
    //2.1获取所有改轮次下的项目
    @RequestMapping("/getProgects")
    @ResponseBody
    public List<Project>  getProgects(@RequestBody Integer sessionId, Integer roundOrder){

        return null;
    }
    //2.1查看是否对当前场次有投票权限
    // SessionUser sessionUser


    //2.2查看是否已经投票
    //2.2.1根据sessionId，round_order,projectId检索出result（list），
    // 判断其userId是否与传入的userId系相同

    //查询sessionId查询sessionInfo和投票类型

    //根据场次及轮次获取项目信息
    public List<Project> getPeojexts(@RequestBody Integer sessonId, Integer roundOrder){


        //下载项目文件utils
        return  null;
    }

    //提交投票结果
    @RequestMapping("/addResult")
    @ResponseBody
    public Message addResult (@RequestBody List<Result> results){



        Message message = null;
        return  message;
    }




}
