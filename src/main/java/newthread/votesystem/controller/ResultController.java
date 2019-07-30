package newthread.votesystem.controller;

import newthread.votesystem.bean.ResultInf;
import newthread.votesystem.bean.ResultMsg;
import newthread.votesystem.bean.Round;
import newthread.votesystem.service.ResultService;
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

    /**
     * 可能需要修改
     * 显示评委投票情况:以投票评委个数
     */
    public Integer getcount(@RequestBody Round round){
        return resultService.count(round.getSessionId(),round.getRoundId());
    }
    /**
     * 查询结果，如果是打分制，计算平均分，如果是投票制显示各票数
     * 结果页面显示：场次名称，投票方式，投票上限，统计方式，投票人数，未投票人数等等
     * @param round(sessionId,roundId)
     * @return 投票结果页面显示的：场次名称，投票方式，统计方式，投票人数，未投票人数等等
     */
    @RequestMapping("/getResultMsg")
    @ResponseBody
    public ResultMsg getResultMsg(@RequestBody Round round){
        return resultService.queryByRoundId(round.getSessionId(),round.getRoundId());
    }

    /**
     * 1.2 计算票数并降序排序
     * @param round（round I的，sessionId）
     * @return 各项目投票结果信息
     */
    @RequestMapping("/getResultInf")
    @ResponseBody
    public List<ResultInf> getResultInf(@RequestBody Round round){
        return resultService.countNote(round.getSessionId(),round.getRoundId());
    }
}
