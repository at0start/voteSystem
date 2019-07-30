package newthread.votesystem.test;

import newthread.votesystem.bean.Result;
import newthread.votesystem.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class UserServiceTest {


    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        UserService userService = context.getBean(UserService.class);

        // queryUser（）
//        User user = new User("j1","123456");
//        System.out.println(employeeService.queryUser(user));
//        System.out.println(userService.queryAll("j1") + "xxxxxxxx");
        //查看是否有投票权限
//        System.out.println(userService.judgeAuthority("j1",2));
        //判断是否投票
        System.out.println(userService.judeVote("j1",2,16));
        //提交投票信息
//        List<Result> results = new ArrayList<>();
//        Result result1 = new Result(2,"第一场",16,2,"j1","11",1,1,0,0,0.0);
//        Result result2 = new Result(2,"第一场",16,3,"j1","2",1,0,1,0,0.0);
//        Result result3 = new Result(2,"第一场",16,4,"j1","3",1,1,0,0,0.0);
//        results.add(result1);
//        results.add(result2);
//        results.add(result3);
//
//        System.out.println(userService.addVoteResult(results));

        context.close();
    }




}
