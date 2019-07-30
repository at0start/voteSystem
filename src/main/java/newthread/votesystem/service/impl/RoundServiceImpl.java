package newthread.votesystem.service.impl;

import newthread.votesystem.bean.Project;
import newthread.votesystem.bean.Round;
import newthread.votesystem.bean.RoundProject;
import newthread.votesystem.bean.Session;
import newthread.votesystem.mappers.RoundMapper;
import newthread.votesystem.mappers.RoundProjectMapper;
import newthread.votesystem.mappers.SessionMapper;
import newthread.votesystem.service.RoundService;
import newthread.votesystem.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 讨论round表是否需要主键 √
 */
@Service("roundService")
public class RoundServiceImpl implements RoundService{

    //轮次 dao
    @Autowired
    RoundMapper roundMapper;

    //场次 dao 实现
    @Autowired
    SessionMapper sessionMapper;

    //项目_场次 dao
    @Autowired
    RoundProjectMapper roundProjectMapper;

    /**
     * 根据场次id查询所有轮次
     * @param sessionId
     * @return
     */
    @Override
    public List<Round> queryAllRoundBySessionId(Integer sessionId) {
        Round round = new Round();
        round.setSessionId(sessionId);
        return roundMapper.select(round);
    }

    /**
     * 添加轮次(返回主键信息)
     * @param round
     * @return
     */
    @Override
    public Integer addRound(Round round,Integer sessionId) {
        //1. 根据场次 id 查询该场次的评选方式
        //1.1. 查询该场次信息
        Session session = sessionMapper.selectByPrimaryKey(sessionId);
        round.setVoteType(session.getVoteType());
        round.setSessionId(sessionId);
        roundMapper.insert(round);
        return round.getRoundId();
    }

    /**
     * 根据主键查询轮次
     * @param roundId
     * @return
     */
    @Override
    public Round queryRound(Integer roundId) {
        return roundMapper.selectByPrimaryKey(roundId);
    }

    /**
     * 更新轮次
     * 返回更新信息
     * @param round
     */
    @Override
    public boolean updateRound(Round round) {
        if(roundMapper.updateByPrimaryKey(round) == 1){
            return true;
        }else return false;

    }

    /**
     * 根据场次以及轮次 id 删除轮次
     * @param roundId
     * @param sessionId
     */
    @Override
    public boolean deleteRound(Integer roundId, Integer sessionId) {
        Round round = new Round();
        //添加场次以及轮次 id 信息
        round.setSessionId(sessionId);
        round.setRoundId(roundId);
        if (roundMapper.delete(round) == 1){
            return true;
        }else return false;
    }

    /**
     * 批量更新项目（先删除后插入）
     * 可能需要返回值
     * @param roundProjects
     */
    @Override
    public boolean addProject(List<RoundProject> roundProjects){
        int insert = 1;
        RoundProject roundProject = new RoundProject();
        //1. 设置场次及轮次 id进行删除
        roundProject.setSessionId(roundProjects.get(0).getSessionId());
        roundProject.setRoundId(roundProjects.get(0).getRoundId());
        roundProjectMapper.delete(roundProject);
        for(int i = 0;i < roundProjects.size();i++){
            //2. 进行插入
            insert = roundProjectMapper.insert(roundProjects.get(i));
            if(insert == 0) break;
        }
        if(insert == 0) return false;
        else return true;
    }
//    public Integer addProject(List<Project> projects,Integer sessionId,Integer roundId) {
//        RoundProject roundProject = new RoundProject();
//        //1. 设置场次及轮次 id进行删除
//        roundProject.setSessionId(sessionId);
//        roundProject.setRoundId(roundId);
//        roundProjectMapper.delete(roundProject);
//        for(int i = 0;i < projects.size();i++){
//            //2. 进行插入
//            //设置 projectid
//            roundProject.setProjectId(projects.get(i).getProjectId());
//            // 插入
//            roundProjectMapper.insert(roundProject);
//        }
//        return 1;
//    }

    /**
     * 查询轮次状态
     * @param roundId
     * @return
     */
    @Override
    public Integer queryRoundState(Integer roundId) {
        //封装查询条件
        Round round = roundMapper.selectByPrimaryKey(roundId);
        return round.getRoundState();
    }

    /**
     * 开启轮次（修改场次轮次状态）？？
     * 返回轮次状态信息：2 开始
     * @return
     */
    @Override
    public Integer startRound(Integer sessionId,Integer roundId) {
        //1. 获取该轮次
        Round round = roundMapper.selectByPrimaryKey(roundId);
        //2. 修改轮次状态：1 -> 2
        round.setRoundState(2);
        //3. 开启轮次
        roundMapper.updateByPrimaryKey(round);
        //4. 开启场次
        //获取场次信息
        Session session = sessionMapper.selectByPrimaryKey(sessionId);
        //修改场次状态 1 -> 2
        session.setSessionState(2);
        sessionMapper.updateByPrimaryKey(session);
        //4. 返回场次轮次状态
        round = roundMapper.selectByPrimaryKey(roundId);
        return round.getRoundState();
    }

    /**
     * 结束轮次
     * 返回轮次状态信息：3 结束
     * @param sessionId
     * @param roundId
     * @return
     */
    @Override
    public Integer endRound(Integer sessionId, Integer roundId) {
        // 获取轮次信息
        Round round = roundMapper.selectByPrimaryKey(roundId);
        // 结束轮次，1 -> 0
        round.setRoundState(3);
        // 更新轮次
        roundMapper.updateByPrimaryKey(round);
        return round.getRoundState();

//        //1. 获取该场次的所有轮次
//        Round round = new Round();
//        round.setSessionId(sessionId);
//        List<Round> rounds = roundMapper.select(round);
//        //2. 获取所有轮次的状态信息
//        int num = 0; // 记录开启的轮次个数
//        for(int i= 0;i < rounds.size();i++){
//            if(rounds.get(i).getRoundState() == 1)
//                num++;
//        }
//        //判断是否是最后一个轮次(如果是，则同时结束场次)
//        if(num == 1){
//            //获取场次
//            Session session = sessionMapper.selectByPrimaryKey(sessionId);
//            //结束场次 3:表示场次结束
//            session.setSessionState(3);
//            //更新场次信息
//            sessionMapper.updateByPrimaryKey(session);
//        }
//        // 3. 结束轮次
//        // 查询要结束的轮次
//        round = roundMapper.selectByPrimaryKey(roundId);
//        // 0 表示结束轮次
//        round.setRoundState(0);
//        // 结束轮次
//        roundMapper.updateByPrimaryKey(round);
//        return round.getRoundState();
    }


//    @Override
//    public List<String> queryResult(Integer sessionId, Integer roundOrder) {
//        return null;
//    }


}
