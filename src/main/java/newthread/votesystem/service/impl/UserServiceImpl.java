package newthread.votesystem.service.impl;

import newthread.votesystem.bean.*;
import newthread.votesystem.bean.webBean.UserVoteInfo;
import newthread.votesystem.mappers.*;
import newthread.votesystem.service.UserService;
import newthread.votesystem.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 评委操作类
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    //用户 dao
    @Autowired
    UserMapper userMapper;
    // 用户权限 dao
    @Autowired
    SessionUserMapper sessionUserMapper;
    // 场次 dao
    @Autowired
    SessionMapper sessionMapper;
    // 轮次 dao
    @Autowired
    RoundMapper roundMapper;
    // 结果 dao
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
     * 更新密码
     * @return
     */
    @Override
    public List<User> updatePassword() {
        List<User> users = userMapper.selectAll();
        for(int i = 0;i < users.size();i++){
            User user = users.get(i);
            user.setUserPassword(FileUtils.generate6BitInt()+"");
            userMapper.updateByPrimaryKeySelective(user);
        }
        return userMapper.selectAll();
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
        List<UserVoteInfo> userVoteInfos = null;
        //1. 封装查询条件
        SessionUser sessionUser = new SessionUser();
        sessionUser.setUserId(userId);
        //2. 构造 UserVoteInfo
        List<SessionUser> sessionUsers = sessionUserMapper.select(sessionUser);
        try {
            userVoteInfos = new ArrayList<>();
            for (SessionUser sUser : sessionUsers) {
                Session session = sessionMapper.selectByPrimaryKey(sUser.getSessionId());
                Round round1 = new Round();
                round1.setSessionId(session.getSessionId());
                List<Round> rounds = roundMapper.select(round1);
                for (Round round : rounds) {
                    System.out.println(round.getRoundOrder());
                    UserVoteInfo userVoteInfo = new UserVoteInfo(session.getSessionId(),session.getSessionName()
                            ,session.getSessionDate(),round.getRoundOrder(),session.getSessionState()
                            ,round.getRoundState(),session.getVoteType(),round.getRoundId());
                    userVoteInfos.add(userVoteInfo);
                }
            }
        }catch (Exception e){
            userVoteInfos = new ArrayList<>();
        }

//        for (int i = 0; i < sessionUsers.size(); i++) {
//////            //2.1. 获取 sessionId
//////            Integer sessionId = sessionUsers.get(i).getSessionId();
//////            //2.2. 获取 session
//////            Session session = sessionMapper.selectByPrimaryKey(sessionId);
//////            //2.3. 获取 round
//////            Round round1 = new Round();
//////            round1.setSessionId(sessionId);
//////            List<Round> rounds = roundMapper.select(round1);
//////            for (int j = 0; j < rounds.size(); j++) {
//////                Round round = rounds.get(i);
//////                //3. 封装 UserVoteInfo;
//////            UserVoteInfo userVoteInfo = new UserVoteInfo(session.getSessionId(),session.getSessionName()
//////                    ,session.getSessionDate(),round.getRoundOrder(),session.getSessionState()
//////                    ,round.getRoundState(),session.getVoteType(),round.getRoundId());
//////                userVoteInfos.add(userVoteInfo);
//////            }
//////        }
        return userVoteInfos;
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
        if(select.size() == 0)
            return false;
        else return true;
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
        System.out.println(resultMapper.select(result));
        //不存在就继续投票
//        ObjectUtils.toString(object,null)
        if (resultMapper.select(result).size() == 0) {
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

    @Override
    public List<User> getAllUsers() {
        return userMapper.selectAll();
    }
}
