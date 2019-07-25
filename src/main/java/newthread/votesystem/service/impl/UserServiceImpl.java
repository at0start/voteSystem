package newthread.votesystem.service.impl;

import newthread.votesystem.bean.*;
import newthread.votesystem.mappers.ResultMapper;
import newthread.votesystem.mappers.SessionUserMapper;
import newthread.votesystem.mappers.UserMapper;
import newthread.votesystem.service.RoundService;
import newthread.votesystem.service.SessionService;
import newthread.votesystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    SessionUserMapper sessionUserMapper;

    @Autowired
    SessionService sessionService;

    @Autowired
    RoundService roundService;

    @Autowired
    ResultMapper resultMapper;

    /**
     * 用户登录
     *
     * @param user
     * @return
     */
    @Override
    public boolean queryUser(User user) {
        if (userMapper.selectOne(user) != null) {
            return true;
        } else return false;
    }

    /**
     * 查询用户参与投票的轮次信息
     * 1. 根据 userId 查询 sessionId
     *
     * @param userId
     * @return
     */
    @Override
    public List<UserVoteInfo> queryAll(String userId) {
        List<UserVoteInfo> userVoteInfos = new ArrayList<>();
        //1. 封装查询条件
        SessionUser sessionUser = new SessionUser();
        sessionUser.setUserId(userId);
        //2. 构造 UserVoteInfo
        List<SessionUser> sessionUsers = sessionUserMapper.select(sessionUser);
        for (int i = 0; i < sessionUsers.size(); i++) {
            //2.1. 获取 sessionId
            Integer sessionId = sessionUsers.get(i).getSessionId();
            //2.2. 获取 session
            Session session = sessionService.getSessionBySessionId(sessionId);
            //2.3. 获取 round
            List<Round> rounds = roundService.queryAllRoundBySessionId(sessionId);
            for (int j = 0; j < rounds.size(); j++) {
                Round round = rounds.get(i);
                //3. 封装 UserVoteInfo;
                UserVoteInfo userVoteInfo = new UserVoteInfo(null,
                        session.getSessionName(), session.getSessionDate(), round.getRoundOrder(),
                        session.getSessionState(), round.getRoundState());
                userVoteInfos.add(userVoteInfo);
            }
        }
        return userVoteInfos;
    }

    /**
     * 参照 ProjectServiceImpl
     *
     * @param sessionId
     * @param roundId
     * @return
     */
    @Override
    public List<Project> queryProject(Integer sessionId, Integer roundId) {
        //获取 session 信息
        Session session = sessionService.getSessionBySessionId(sessionId);
        return null;
    }

    /**
     * 判断用户是否有（投票）权限，查询 session_user 表
     * @param userId
     * @param sessionId
     * @return
     */
    @Override
    public boolean judgeAuthority(String userId, Integer sessionId) {
        //1. 封装查询条件
        SessionUser sessionUser = new SessionUser();
        sessionUser.setUserId(userId);
        sessionUser.setSessionId(sessionId);
        //2. 判断
        if(sessionUserMapper.select(sessionUser) != null){
            return true;
        }else return false;
    }

    /**
     * 判断用户是否投票（评分），查询 result 表
     * @param userId
     * @param sessionId
     * @param roundId
     * @return
     */
    @Override
    public boolean judeVote(String userId, Integer sessionId, Integer roundId) {
        //1. 封装查询条件
        Result result = new Result();
        result.setUserId(userId);
        result.setRoundId(roundId);
        result.setSessionId(sessionId);
        //2. 判断
        List<Result> select = resultMapper.select(result);
        if(select == null) return true;
        else return false;
    }

    /**
     * 提交投票信息(提交投票前需要判断是否用户是否投过票，并返回是否投票信息)
     *
     * @param results
     * @return
     */
    @Override
    public boolean addVoteResult(List<Result> results) {
        int insert = 1;
        //1. 判断是否提交投票
        //获取一条投票信息
        Result result = results.get(0);
        //不存在就继续投票
        if (resultMapper.select(result) == null) {
            //提交投票信息
            for (int i = 0; i < results.size(); i++) {
                 insert = resultMapper.insert(results.get(i));
                if(insert == 0){
                    break;
                }
            }
        }
        if(insert == 0) return false;
        else return true;
    }
}
