package newthread.votesystem.controller;

import newthread.votesystem.bean.Round;
import newthread.votesystem.bean.RoundProject;
import newthread.votesystem.bean.Session;
import newthread.votesystem.service.RoundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * @author 一个糟老头子
 * @createDate 2019/7/17-15:34
 */
@Controller
public class RoundController {

    @Autowired
    RoundService roundService;

    /**
     * 获取当前场次的所以轮次
     * @param session
     * @return
     */
    @RequestMapping("/getRoundsBySessionId")
    @ResponseBody
    public List<Round> getRoundsBySessionId(@RequestBody Session session){
        return roundService.queryAllRoundBySessionId(session.getSessionId());
    }
    /**
     * 添加轮次
     * @param round
     * @return
     */
    @RequestMapping("/addRound")
    @ResponseBody
    public Round addRound(@RequestBody Round round){
        //默认轮次为状态为0
        round.setRoundState(1);
        Integer roundId = roundService.addRound(round,round.getSessionId());
        //将轮次信息录入round表
        return roundService.queryRound(roundId);
    }

    /**
     * 查询轮次信息
     * @param  round （roundId）
     * @return
     */
    @RequestMapping("/getRoundById")
    @ResponseBody
    public Round getRoundById(@RequestBody Round round){
        return  roundService.queryRound(round.getRoundId());
    }

    /**
     * 修改轮次信息
     * @param round （修改后的信息）
     * @return
     */
    @RequestMapping("/updateRound")
    @ResponseBody
    public Round updateRound(@RequestBody Round round){
        roundService.updateRound(round);
        return  roundService.queryRound(round.getRoundId());
    }

    /**
     * @param round（sessionId,roundId）
     * 删除轮次
     * @return
     */
    @RequestMapping("/deleteRound")
    @ResponseBody
    public boolean deleteRound(@RequestBody Round round){
        return  roundService.deleteRound(round.getRoundId(),round.getSessionId());
    }


    /**
     * 给轮次添加项目
     * @param roundProjects（sessionId,roundId,projectId）
     * @return
     */
    @RequestMapping("/addRoundProject")
    @ResponseBody
    public boolean addRoundProject(@RequestBody List<RoundProject> roundProjects){
        return roundService.addProject(roundProjects);
    }


    /**
     * 开始轮次1改为2,同时将场次状态从1改为2
     * @param round（sessionId,roundId）
     * @return
     */
    @RequestMapping("/startRound")
    @ResponseBody
    public boolean startRound(@RequestBody Round round){
        int roundState = roundService.startRound(round.getSessionId(),round.getRoundId());
        return roundState==2?true:false;
    }

    /**
     *  结束轮次2改为3
     * @param round（sessionId,roundId）
     * @return
     */
    @RequestMapping("/endRound")
    @ResponseBody
    public boolean endRound(@RequestBody Round round){
        System.out.println(round.toString());
        int roundState = roundService.endRound(round.getSessionId(),round.getRoundId());
        return roundState==3?true:false;
    }



}
