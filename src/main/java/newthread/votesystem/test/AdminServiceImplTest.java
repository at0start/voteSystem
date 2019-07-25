package newthread.votesystem.test;

import newthread.votesystem.bean.Admin;
import newthread.votesystem.service.AdminService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AdminServiceImplTest {

    @Test
    public void queryAdmin() {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        AdminService adminService= context.getBean(AdminService.class);

        Admin admin = new Admin("j1","123456");
        System.out.println(admin);
        System.out.println(adminService.queryAdmin(admin));

    }

    @Test
    public void queryAll() {
    }

    @Test
    public void queryProject() {
    }

    @Test
    public void judge() {
    }

    @Test
    public void addVoteResult() {
    }
}
