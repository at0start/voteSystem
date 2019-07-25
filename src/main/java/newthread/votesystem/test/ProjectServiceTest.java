package newthread.votesystem.test;

import newthread.votesystem.bean.Project;
import newthread.votesystem.service.ProjectService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProjectServiceTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new
                ClassPathXmlApplicationContext("applicationContext.xml");

        ProjectService projectService = context.getBean(ProjectService.class);

        //添加项目
        Project project = new Project();

    }

}
