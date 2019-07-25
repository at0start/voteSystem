package newthread.votesystem.service.impl;

import newthread.votesystem.bean.Result;
import newthread.votesystem.bean.Session;
import newthread.votesystem.bean.T;
import newthread.votesystem.mappers.ResultMapper;
import newthread.votesystem.mappers.SessionMapper;
import newthread.votesystem.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ResultService")
public class ResultServiceImpl implements ResultService {

    @Autowired
    ResultMapper resultMapper;

    @Autowired
    SessionMapper sessionMapper;

    /**
     * 计算评委投票情况（返回已投票）
     * @param sessionId
     * @param roundId
     * @return
     */
    @Override
    public Integer count(Integer sessionId, Integer roundId) {
        // 封装查询条件
        Result result = new Result();
        result.setSessionId(sessionId);
        result.setRoundId(roundId);
        //查询
        //1. 获取评委人数
        Session session = sessionMapper.selectByPrimaryKey(sessionId);
        Integer userNumber = session.getUserNumber();
        List<Result> select = resultMapper.select(result);
        //计算已投票人数
        int number = select.size() / userNumber;
        return number;
    }

    /**
     * 根据 sessionId 以及 roundId  查询结果
     * @param sessionId
     * @param roundOrder
     * @return
     */
    @Override
    public Result queryByRoundId(Integer sessionId, Integer roundOrder) {
        return null;
    }

    @Override
    public List<T> countNote(Integer sessionId, Integer countId) {
        return null;
    }

    @Override
    public List<Integer> countGrade(Integer sessionId, Integer countId) {
        return null;
    }
}
