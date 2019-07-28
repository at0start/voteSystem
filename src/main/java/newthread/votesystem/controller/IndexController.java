package newthread.votesystem.controller;

import newthread.votesystem.bean.Admin;
import newthread.votesystem.bean.User;
import newthread.votesystem.service.AdminService;
import newthread.votesystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 一个糟老头子
 * @createDate 2019/7/17-15:29
 */
@Controller
public class IndexController {

    @Autowired
    AdminService adminService;

    @Autowired
    UserService userService;


    @RequestMapping("/adminLogin")
    @ResponseBody
    public boolean adminIndex(@RequestBody Admin admin){
        return adminService.queryAdmin(admin);
    }

    @RequestMapping("/userLogin")
    @ResponseBody
    public boolean userLogin(@RequestBody User user){
        return userService.queryUser(user);
    }

}
