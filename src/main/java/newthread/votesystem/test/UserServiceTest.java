package newthread.votesystem.test;

import newthread.votesystem.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceTest {


    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserService employeeService = context.getBean(UserService.class);

        // queryUser（）
//        User user = new User("j1","123456");
//        System.out.println(employeeService.queryUser(user));


        context.close();
    }




}
