package newthread.votesystem.controller;

import newthread.votesystem.bean.Admin;
import newthread.votesystem.bean.User;
import newthread.votesystem.service.AdminService;
import newthread.votesystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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


    @RequestMapping(value = "/adminLogin",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public boolean adminIndex(@RequestBody Admin admin, HttpServletRequest request) {
        if (adminService.queryAdmin(admin)) {
            request.getSession().setAttribute("userName", admin.getAdminId());
            return true;
        } else {
            return false;
        }
    }

    @RequestMapping(value = "/userLogin",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public boolean userLogin(@RequestBody User user, HttpServletRequest request) {
        if (userService.queryUser(user)) {
            request.getSession().setAttribute("userName", user.getUserId());
            return true;
        } else {
            return false;
        }
    }

    @RequestMapping("/logout")
    @ResponseBody
    public boolean logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().invalidate();
        response.sendRedirect("/**/index.html");
        return true;
    }
}
