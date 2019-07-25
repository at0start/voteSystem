package newthread.votesystem.service;


import newthread.votesystem.bean.Project;
import newthread.votesystem.bean.Round;

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
    void updateRound(Round round);

    //删除轮次
    void deleteRound(Integer roundId,Integer sessionId);

    //批量添加项目？？？
    //1. 查询该场次所有项目
    //2. 添加到该轮次下
    void addProject(List<Project> projects,Integer sessionId,Integer roundId);

    //批量取消项目
    void deleteBathProject(List<Project> projects);

    //开始轮次，修改场次、轮次状态???
    Integer updateRoundState(Integer sessionId,Integer roundId);

    //查看评委结果
    List<String> queryResult(Integer sessionId, Integer roundOrder);

    //查看评审结果


}
