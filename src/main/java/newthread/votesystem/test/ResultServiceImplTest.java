package newthread.votesystem.test;

import newthread.votesystem.bean.Result;
import newthread.votesystem.bean.ResultMsg;
import newthread.votesystem.service.ResultService;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sun.tools.jar.Main;

public class ResultServiceImplTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        ResultService resultService = context.getBean(ResultService.class);

        //计算评委投票情况
//        System.out.println(resultService.count(2,16));

        //
//        ResultMsg resultMsg = resultService.queryByRoundId(2, 16);
//        System.out.println(resultMsg);

        System.out.println(resultService.getUser(2,16));

    }

}
