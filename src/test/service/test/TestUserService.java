package service.test;

import newthread.votesystem.model.User;
import newthread.votesystem.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class TestUserService {




    public static void main(String[] args) {
        UserService userService = new UserService();
        User user = new User();
        user.setUserId("j1");
        user.setUserPassword("123456");
        System.out.println(user.toString());
        boolean b = userService.queryUser(user);
        System.out.println(b);
    }

}
