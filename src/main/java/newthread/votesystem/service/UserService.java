package newthread.votesystem.service;


import newthread.votesystem.bean.Project;
import newthread.votesystem.bean.Result;
import newthread.votesystem.bean.User;
import newthread.votesystem.bean.UserVoteInfo;

import java.util.List;

public interface UserService {

//    @Autowired
//    public UserMapper userMapper;
//
//    //查询登录用户是否存在
    public boolean queryUser(User user);

    //随机更改密码

    //查询轮次
    //1. 根据 userId 查询 sessionId
    //2. 根据sessionId 查询 场次编号、场次名称、场次时间、轮次（新建类）
    List<UserVoteInfo> queryAll(String userId);

    //开始投票
    //1. 查询该场次该轮次下的项目
//    List<Project> queryProject(Integer sessionId, Integer roundOrder);

    //2. 查询场次信息（评选规则、投票制）


    //提交投票
    //1. 判断是否投票（投票状态）,以及是否有投票权限
    //1.1. 判断是否有投票权限
    boolean judgeAuthority(String userId,Integer sessionId);

    //1.2. 判断是否投票
    boolean judeVote(String userId,Integer sessionId,Integer roundId);

    //2.查询场次信息，该场次该轮次项目信息，项目文件

    //3.下载

    //4. 提交用户投票结果(投票前需要判断是否用户是否投过票，并返回是否投票信息)
    boolean addVoteResult(List<Result> results);



}
