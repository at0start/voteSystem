package newthread.votesystem.service;


import newthread.votesystem.bean.Result;
import newthread.votesystem.bean.User;
import newthread.votesystem.bean.webBean.UserVoteInfo;

import java.io.File;
import java.util.List;

public interface UserService {
    //查询登录用户是否存在
    boolean queryUser(User user);

    //随机更改密码
    List<User> updatePassword();

    // 根据sessionId 查询 场次编号、场次名称、场次时间、轮次（新建类）
    List<UserVoteInfo> queryAll(String userId);


    //提交投票
    //1. 判断是否投票（投票状态）,以及是否有投票权限
    //1.1. 判断是否有投票权限
    boolean judgeAuthority(String userId,Integer sessionId);

    //1.2. 判断是否投票
    boolean judeVote(String userId,Integer sessionId,Integer roundId);


    // 提交用户投票结果(投票前需要判断是否用户是否投过票，并返回是否投票信息)
    boolean addVoteResult(List<Result> results);

    //获取修改密码后的所有用户信息
    List<User> getAllUsers();

}
