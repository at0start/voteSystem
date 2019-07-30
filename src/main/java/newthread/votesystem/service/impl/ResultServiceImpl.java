package newthread.votesystem.service.impl;

import newthread.votesystem.bean.*;
import newthread.votesystem.mappers.ProjectMapper;
import newthread.votesystem.mappers.ResultMapper;
import newthread.votesystem.mappers.RoundProjectMapper;
import newthread.votesystem.mappers.SessionMapper;
import newthread.votesystem.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 评审结果操作类
 */
@Service("ResultService")
public class ResultServiceImpl implements ResultService {

    // 评审结果 dao
    @Autowired
    ResultMapper resultMapper;
    // 场次 dao
    @Autowired
    SessionMapper sessionMapper;
    // 轮次项目 dao
    @Autowired
    RoundProjectMapper roundProjectMapper;
    // 场次项目 dao
    @Autowired
    ProjectMapper projectMapper;

    /**
     * 计算评委投票情况（返回已投票）
     *
     * @param sessionId
     * @param roundId
     * @return
     */
    @Override
    public Integer count(Integer sessionId, Integer roundId) {
        // 封装查询条件
        //封装查询一个轮次的项目个数
        RoundProject roundProject = new RoundProject();
        roundProject.setSessionId(sessionId);
        roundProject.setRoundId(roundId);
        //封装查询一个轮次的结果
        Result result = new Result();
        result.setSessionId(sessionId);
        result.setRoundId(roundId);
        //查询
        //1. 获取项目个数(round_user)
        List<RoundProject> roundProjects = roundProjectMapper.select(roundProject);
        Integer projectNumber = roundProjects.size();
        List<Result> select = resultMapper.select(result);
        //计算已投票人数
        int number = select.size() / projectNumber;
        return number;
    }


    /**
     * 根据 sessionId 以及 roundId  查询结果(一些信息)
     *
     * @param sessionId
     * @param roundId
     * @return
     */
    @Override
    public ResultMsg queryByRoundId(Integer sessionId, Integer roundId) {
        //查询场次信息
        Session session = sessionMapper.selectByPrimaryKey(sessionId);
        ResultMsg resultMsg = new ResultMsg(session.getSessionId(),
                session.getSessionName(), session.getVoteType(),
                null, count(sessionId, roundId),
                session.getUserNumber() - count(sessionId, roundId));
        if (session.getVoteType() == "V") {
            resultMsg.setCountType("全部累加");
        } else {
            resultMsg.setCountType("去掉最高分和最低分，取平均值");
        }
        return resultMsg;
    }

    /**
     * 返回结果信息（数据表）
     *
     * @param sessionId
     * @param roundId
     * @return
     */
    @Override
    public List<ResultInf> countNote(Integer sessionId, Integer roundId) {
        //创建组合类
        List<ResultInf> resultInfs = new ArrayList<>();
        //赞成票个数
        int pass = 0;
        //反对票
        int out = 0;
        //弃权票
        int abstention = 0;
        //分数
        double scoreFinal = 0.0;
        //根据场次及轮次id获取项目id
        RoundProject roundProject = new RoundProject();
        roundProject.setSessionId(sessionId);
        roundProject.setRoundId(roundId);
        List<RoundProject> roundProjects = roundProjectMapper.select(roundProject);
        //1. 判断场次投票方式（投票/打分）
        Session session = sessionMapper.selectByPrimaryKey(sessionId);
        //获取评委人数（默认都打分）
        Integer userNumber = session.getUserNumber();
        String voteType = session.getVoteType();
        //投票制
        if (voteType.equals("v")) {
            //根据场次，轮次，项目id计算票数
            //获取 i 各项目
            for (int i = 0; i < roundProjects.size(); i++) {
                //获取一个项目的所有结果
                Result result = new Result();
                result.setSessionId(sessionId);
                result.setRoundId(roundId);
                result.setProjectId(roundProjects.get(i).getProjectId());
                List<Result> results = resultMapper.select(result);
                for (int j = 0; j < results.size(); j++) {
                    if (results.get(j).getPassVote() == 1) {
                        pass++;
                    }
                    if (results.get(j).getOutVote() == 1) {
                        out++;
                    }
                    if (results.get(j).getAbstentionVote() == 1) {
                        abstention++;
                    }
                }
                //根据项目 id 查询项目信息
                Project project = projectMapper.selectByPrimaryKey(roundProjects.get(i).getProjectId());
                //封装结果信息
                ResultInf resultInf = new ResultInf(project.getProjectId(), null, project.getProjectName(), pass, out, abstention, 0.0);
                resultInfs.add(resultInf);
                //清零
                pass = 0;
                out = 0;
                abstention = 0;
            }
            // 排序
            Collections.sort(resultInfs, new Comparator<ResultInf>() {
                @Override
                public int compare(ResultInf o1, ResultInf o2) {
                    //先根据赞成票数排序，赞成票数相同，则按照反对票数排序
                    int passNum = o1.getPassVote() - o2.getPassVote();
                    int outNum = o1.getOutVote() - o2.getOutVote();
                    if (passNum > 0) {
                        return -1;
                    } else if (passNum < 0) {
                        return 1;
                    } else {
                        if (outNum < 0) return 1;
                        else if (outNum > 0) return -1;
                        else return 0;
                    }
                }
        });
        return resultInfs;
    } else

    {
        //根据场次，轮次，项目id计算分数（去掉最高分和最低分）
        //获取 i 各项目
        for (int i = 0; i < roundProjects.size(); i++) {
            //获取一个项目的所有结果
            Result result = new Result();
            result.setSessionId(sessionId);
            result.setRoundId(roundId);
            result.setProjectId(roundProjects.get(i).getProjectId());
            List<Result> results = resultMapper.select(result);
            //定义一个数组存放分数
            double[] scores = new double[results.size()];
            for (int j = 0; j < results.size(); j++) {
                Double score = results.get(j).getScore();
                scores[j] = score;
            }
            //计算一个项目的总分数
            Arrays.sort(scores);
            for (int k = 1; k < results.size() - 1; k++)
                scoreFinal += scores[k];
            scoreFinal = scoreFinal / (results.size() - 2);
            //根据项目 id 查询项目信息
            Project project = projectMapper.selectByPrimaryKey(roundProjects.get(i).getProjectId());
            //封装结果信息
            ResultInf resultInf = new ResultInf(project.getProjectId(), null, project.getProjectName(), 0, 0, 0, scoreFinal);
            resultInfs.add(resultInf);
            scoreFinal = 0;
        }
        Collections.sort(resultInfs, new Comparator<ResultInf>() {
            @Override
            public int compare(ResultInf o1, ResultInf o2) {
                //根据分数降序排序
                double s = o1.getScore() - o2.getScore();
                if(s > 0) return -1;
                else if(s < 0) return 1;
                return 0;
            }
        });
        return resultInfs;
    }

}

    /**
     * 查询用户投票信息
     *
     * @param sessionId
     * @param roundId
     * @return
     */
    @Override
    public List<String> getUser(Integer sessionId, Integer roundId) {
        Result result = new Result();
        result.setRoundId(roundId);
        result.setSessionId(sessionId);
        List<Result> select = resultMapper.select(result);
        Set<String> strings = new HashSet<>();
        for (int i = 0; i < select.size(); i++) {
            strings.add(select.get(i).getUserId());
        }
        Object[] objects = strings.toArray();
        List<String> users = new ArrayList<>();
        for (int i = 0; i < strings.size(); i++) {
            users.add(objects[i].toString().substring(1));
        }
        return users;
    }
}
