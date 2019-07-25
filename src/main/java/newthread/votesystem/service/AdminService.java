package newthread.votesystem.service;

import newthread.votesystem.bean.Admin;
import newthread.votesystem.bean.Project;
import newthread.votesystem.bean.Result;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdminService {

//    @Autowired
//    AdminMapper adminMapper;

    //查询登录用户是否存在
    public boolean queryAdmin(Admin admin);

    //查询轮次
    //1. 根据 userId 查询 sessionId
    //2. 根据sessionId 查询 场次编号、场次名称、场次时间、轮次（新建类）
    List<String> queryAll(String userId);


    //开始投票
    //1. 查询该场次该轮次下的项目
    List<Project> queryProject(Integer sessionId, Integer roundOrder);

    //2. 查询场次信息（评选规则、投票制）


    //提交投票
    //1. 判断是否投票（投票状态）,以及是否有投票权限
    boolean judge(String userId,Integer sessionId,Integer roundOrder);

    //2.查询场次信息，该场次该轮次项目信息，项目文件

    //3.下载

    //4. 提交用户投票结果(投票前需要判断是否用户是否投过票，并返回是否投票信息)
    boolean addVoteResult(List<Result> results);

}
