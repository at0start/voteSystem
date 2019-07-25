package newthread.votesystem.service.impl;

import newthread.votesystem.bean.Project;
import newthread.votesystem.bean.Round;
import newthread.votesystem.bean.RoundProject;
import newthread.votesystem.bean.Session;
import newthread.votesystem.mappers.RoundMapper;
import newthread.votesystem.mappers.RoundProjectMapper;
import newthread.votesystem.service.RoundService;
import newthread.votesystem.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 讨论round表是否需要主键
 */
@Service("roundService")
public class RoundServiceImpl implements RoundService{

    //轮次 dao
    @Autowired
    RoundMapper roundMapper;

    //场次 dao 实现
    @Autowired
    SessionService sessionService;

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
        Session session = sessionService.getSessionBySessionId(sessionId);
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
     * @param round
     */
    @Override
    public void updateRound(Round round) {
        roundMapper.updateByPrimaryKey(round);
    }

    /**
     * 根据场次以及轮次 id 删除轮次
     * @param roundId
     * @param sessionId
     */
    @Override
    public void deleteRound(Integer roundId, Integer sessionId) {
        Round round = new Round();
        //添加场次以及轮次 id 信息
        round.setSessionId(sessionId);
        round.setRoundId(roundId);
        roundMapper.delete(round);
    }

    /**
     * 批量更新项目（先删除后插入）
     * @param projects
     */
    @Override
    public void addProject(List<Project> projects,Integer sessionId,Integer roundId) {
        RoundProject roundProject = new RoundProject();
        //1. 设置场次及轮次 id进行删除
        roundProject.setSessionId(sessionId);
        roundProject.setRoundId(roundId);
        roundProjectMapper.delete(roundProject);
        for(int i = 0;i < projects.size();i++){
            //2. 进行插入
            //设置 projectid
            roundProject.setProjectId(projects.get(i).getProjectId());
            // 插入
            roundProjectMapper.insert(roundProject);
        }
    }



    @Override
    public void deleteBathProject(List<Project> projects) {

    }

    /**
     * 开启轮次（修改场次轮次状态）？？
     * @return
     */
    @Override
    public Integer updateRoundState(Integer sessionId,Integer roundId) {
        //1. 获取该轮次
        Round round = roundMapper.selectByPrimaryKey(roundId);
        //2. 修改轮次状态：0 -> 1
        round.setRoundState(1);
        //3. 更新轮次
        roundMapper.updateByPrimaryKey(round);
        //4. 更新场次
        sessionService.updateSessionState(sessionId);
        //4. 返回场次轮次状态
        round = roundMapper.selectByPrimaryKey(roundId);
        return round.getRoundState();
    }

    @Override
    public List<String> queryResult(Integer sessionId, Integer roundOrder) {
        return null;
    }
}
