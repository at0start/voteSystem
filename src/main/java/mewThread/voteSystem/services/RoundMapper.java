package mewThread.voteSystem.services;

import com.sun.xml.internal.bind.v2.util.CollisionCheckStack;
import mewThread.voteSystem.model.Project;
import mewThread.voteSystem.model.Result;
import mewThread.voteSystem.model.Round;

import java.util.List;

/**
 * 操作轮次
 */
public interface RoundMapper {

    //根据场次查询所有轮次
    void queryAllRoundBySessionId(Integer sessionId);

    //添加轮次??
    Round addRound(Round round);

    //修改轮次信息
    void updateRound(Round round);

    //删除轮次
    void deleteRound(Integer roundOrder,Integer sessionId);

    //批量添加项目？？？
    //1. 查询该场次所有项目
    //2. 添加到该轮次下
    void addProject(List<Project> projects);

    //批量取消项目
    void deleteBathProject(List<Project> projects);

    //开始轮次，修改场次、轮次状态???
    Integer updateRoundState();

    //查看评委结果
    List<String> queryResult(Integer sessionId,Integer roundOrder);

    //查看评审结果


}
