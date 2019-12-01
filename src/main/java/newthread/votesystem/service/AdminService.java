package newthread.votesystem.service;

import newthread.votesystem.bean.Admin;
import org.springframework.stereotype.Service;


@Service
public interface AdminService {

//    @Autowired
//    AdminMapper adminMapper;

    //查询登录用户是否存在
    boolean queryAdmin(Admin admin);


}
