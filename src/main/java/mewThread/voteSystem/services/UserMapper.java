package mewThread.voteSystem.services;

import mewThread.voteSystem.model.Project;
import mewThread.voteSystem.model.Round;

import java.util.List;

public interface UserMapper {

    //查询登录用户是否存在
    boolean queryUser(String username,String password);

    //查询轮次
    //1. 根据 userId 查询 sessionId
    //2. 根据sessionId 查询 场次编号、场次名称、场次时间、轮次（新建类）
    List<String> queryAll(String userId);

    //开始投票
    //1. 查询该场次该轮次下的项目
    List<Project> queryProject(Integer sessionId,Integer roundOrder);

    //2. 查询场次信息（评选规则、投票制）


    //提交投票
    //1. 判断是否投票（投票状态）


    //下载


}
