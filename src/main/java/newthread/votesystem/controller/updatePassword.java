package newthread.votesystem.controller;

import newthread.votesystem.bean.User;
import newthread.votesystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

/**
 * @author 一个糟老头子
 * @createDate 2019/7/19-16:21
 */
@Controller
public class updatePassword {

    @Autowired
    UserService userService;

    /**
     * 修改并返回修改后的评委密码
     * @return
     */
    @RequestMapping("/updatePassword")
    @ResponseBody
    public List<User> updatePassword(){
        return userService.updatePassword();
    }
}
