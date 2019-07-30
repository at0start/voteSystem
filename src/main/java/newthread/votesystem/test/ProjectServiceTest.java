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
        Project project = new Project(null,2,1,"3","1","计科","xq",null,null,"无");
        boolean b = projectService.addProject(project);
        System.out.println(b);

        //查询项目
//        //1. 根据场次
//        System.out.println(projectService.queryAllProject(2));
//        //2. 根据项目主键查询项目
//        System.out.println(projectService.queryProjectByProjectId(2));

        //更新项目
//        Project project = new Project(2,2,1,"11","1","计科","xq",null,null,"无");
//        System.out.println(projectService.updateProject(project));
    }

}
