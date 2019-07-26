package newthread.votesystem.service;


import newthread.votesystem.bean.Result;
import newthread.votesystem.bean.ResultInf;
import newthread.votesystem.bean.ResultMsg;

import java.util.List;

public interface ResultService {

    //投票制
    //1. 查询场次信息

    //2. 查询 result 表（投票制）
    //2.1. 计算专家是否投票情况
    Integer count(Integer sessionId,Integer roundId);//以投票人数
    //
    ResultMsg queryByRoundId(Integer sessionId, Integer roundId);
    //2.2. 查询投票统计结果
    //2.2.1 该场次该轮次项目信息

    //2.3. 计算票数
    //创建一个类（。。。）(根据分组)
    List<ResultInf> countNote(Integer sessionId, Integer countId);

    //打分制:
    // 查询一个项目分数（根据sessionId，countId利用projectOrder分组）
    // 去掉最高分和最低分求出一个分数，累次求n次（项目总数）


}
