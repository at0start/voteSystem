package newthread.votesystem.test;

import newthread.votesystem.service.RoundService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RoundServiceImplTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        RoundService roundService = context.getBean(RoundService.class);

        //1. 新增轮次
//        for (int i = 2; i < 10; i++) {
//            Round round = new Round();
//            round.setRoundOrder(i);
//            round.setUpLimit(10);
//            roundService.addRound(round, 2);
//        }

        //2. 查询轮次
//        roundService.deleteRound(15,2);

//        //添加项目
//        List<Project> projects = new ArrayList<>();
//        for (int i = 1; i < 5; i++) {
//            Project project = new Project();
//            project.setProjectId(i);
//            projects.add(project);
//        }
//        roundService.addProject(projects,3,17);

        //updateRoundState
        roundService.updateRoundState(3,17);

    }

}
