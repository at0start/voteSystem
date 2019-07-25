package newthread.votesystem.controller;

import newthread.votesystem.bean.Message;
import newthread.votesystem.bean.Round;
import newthread.votesystem.bean.RoundProject;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.transform.Result;
import java.util.List;

/**
 * @author 一个糟老头子
 * @createDate 2019/7/17-15:34
 */
public class RoundController {

//    修改轮次信息和添加轮次，将信息存放在前端，添加轮次项目时传过来

    //添加轮次
    @RequestMapping("/addRound")
    @ResponseBody
    public Round addRound(@RequestBody Round round){
        //默认轮次为1
        //将轮次信息录入round表
        return round;
    }

    @RequestMapping("/updateRound")
    public Round updateRound(@RequestBody Round round){

        return  round;
    }

    //删除轮次
    public Message deleteRount(@RequestBody Integer roundOrder, Integer sessionId){
        Message message = null;
        return  message;
    }


//    添加项目
    public Message addProject(@RequestBody List<RoundProject> roundProjects){
        Message message = null;
        return  message;
    }

    //开始轮次1改2,同时将场次状态从1改为2
    public Message startRound(@RequestBody Integer roundState){

        Message message = null;
        return message;
    }

    //结束轮次2改3

    //修改轮次信息 先获得轮次信息（sessionId，roundOrder），再修改
    //评委打分情况（sessionId，roundOrder）
    public Message addResult(@RequestBody Result result){

        //判断那些已经打分
        Message message = null;
        return message;
    }

}
