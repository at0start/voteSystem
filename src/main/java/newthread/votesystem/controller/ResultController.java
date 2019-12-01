package newthread.votesystem.controller;

import newthread.votesystem.bean.Round;
import newthread.votesystem.bean.webBean.*;
import newthread.votesystem.bean.Session;
import newthread.votesystem.service.ResultService;
import newthread.votesystem.service.RoundService;
import newthread.votesystem.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

/**
 * @author 一个糟老头子
 * @createDate 2019/7/17-15:37
 */
@Controller
public class ResultController {

    @Autowired
    ResultService resultService;

    @Autowired
    SessionService sessionService;

    @Autowired
    RoundService roundService;

    /**
     * 查询那些评委已投票界面信息
     * @param round(sessionId,roundId)
     * @return
     */
    @RequestMapping("/getVoting")
    @ResponseBody
    public Voting getVoting(@RequestBody Round round){
        Voting voting =new Voting();
            //获取轮次编号
            Round round1 = roundService.queryRound(round.getRoundId());
            //获取sessionName
            Session session = sessionService.getSessionBySessionId(round.getSessionId());
            //获取评委数目
            Integer userNumber = sessionService.getUserNum(round.getSessionId());
            //获取已投票评委编号
            List<String> list = resultService.getUser(round.getSessionId(),round.getRoundId());

            voting.setList(list);
            voting.setRoundOrder(session.getUserNumber());
            voting.setUserNumber(userNumber);
            voting.setRoundOrder(round1.getRoundOrder());
            voting.setSessionName(session.getSessionName());
        return voting;
    }

    /**
     * 获取投票结果
     * @param srUid
     * @return
     */
    @RequestMapping("/getResultInfandMsg")
    @ResponseBody
    public ResultInfandMsg getResultInfandMsg(@RequestBody SRUid srUid){
        ResultInfandMsg resultInfandMsg  =new ResultInfandMsg();
            /*
             * 1.2 计算票数并降序排序
             * @param round（round I的，sessionId）
             * @return 各项目投票结果信息
             */
            List<ResultInf> list =resultService.countNote(srUid.getSessionId(),srUid.getRoundId());
            /*
             * 查询结果，如果是打分制，计算平均分，如果是投票制显示各票数
             * 结果页面显示：场次名称，投票方式，投票上限，统计方式，投票人数，未投票人数等等
             * @param round(sessionId,roundId)
             * @return 投票结果页面显示的：场次名称，投票方式，统计方式，投票人数，未投票人数等等
             */
            ResultMsg resultMsg = resultService.queryByRoundId(srUid.getSessionId(),srUid.getRoundId());
            resultInfandMsg.setResultMsg(resultMsg);
            resultInfandMsg.setResults(list);
        return  resultInfandMsg;
    }
}
