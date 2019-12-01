package newthread.votesystem.service.impl;

import newthread.votesystem.bean.Admin;
import newthread.votesystem.mappers.AdminMapper;
import newthread.votesystem.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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


}
