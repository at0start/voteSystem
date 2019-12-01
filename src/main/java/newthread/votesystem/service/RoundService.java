package newthread.votesystem.service;


import newthread.votesystem.bean.Round;
import newthread.votesystem.bean.RoundProject;

import java.util.List;

/**
 * 操作轮次
 */
public interface RoundService {

    //根据场次查询所有轮次
    List<Round> queryAllRoundBySessionId(Integer sessionId);

    //添加轮次??
    Integer addRound(Round round,Integer sessionId);

    //根据轮次id查询轮次
    Round queryRound(Integer roundId);

    //修改轮次信息
    boolean updateRound(Round round);

    //删除轮次
    boolean deleteRound(Integer roundId,Integer sessionId);

    //批量添加项目？？？
    //1. 查询该场次所有项目
    //2. 添加到该轮次下
//    Integer addProject(List<Project> projects,Integer sessionId,Integer roundId);
    boolean addProject(List<RoundProject> projects);


    //查询轮次状态
    Integer queryRoundState(Integer roundId);

    //开始轮次，修改场次、轮次状态???
    Integer startRound(Integer sessionId,Integer roundId);

    //结束轮次
    Integer endRound(Integer sessionId,Integer roundId);


}
