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


}
