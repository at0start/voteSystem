package newthread.votesystem.service.impl;

import newthread.votesystem.bean.Admin;
import newthread.votesystem.bean.Project;
import newthread.votesystem.bean.Result;
import newthread.votesystem.mappers.AdminMapper;
import newthread.votesystem.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "adminService")
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminMapper adminMapper;

    /**
     * 管理员登录
     * @param admin
     * @return
     */
    public boolean queryAdmin(Admin admin){
        if(adminMapper.selectOne(admin) != null){
            return true;
        }else return false;
    }

    /**
     *
     * @param userId
     * @return
     */
    @Override
    public List<String> queryAll(String adminId) {
        return null;
    }

    @Override
    public List<Project> queryProject(Integer sessionId, Integer roundOrder) {
        return null;
    }

    @Override
    public boolean judge(String userId, Integer sessionId, Integer roundOrder) {
        return false;
    }

    @Override
    public boolean addVoteResult(List<Result> results) {
        return false;
    }

}
