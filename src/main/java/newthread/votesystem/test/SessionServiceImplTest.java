package newthread.votesystem.test;

import newthread.votesystem.bean.Session;
import newthread.votesystem.service.SessionService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class SessionServiceImplTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        SessionService sessionService= context.getBean(SessionService.class);
//        //测试 addSession() 方法
//        Session session = new Session();
//        session.setSessionDate(new Date());
//        session.setSessionName("第一场");
//        session.setVoteType("v");
//        session.setSessionState(0);
//        session.setUserNumber(10);
//        System.out.println(sessionService.addSession(session));
//        System.out.println(session.getSessionId());
////
//        //测试getSessionBySessionId() 方法
////        System.out.println(sessionService.getSessionBySessionId(2));
//
//        //getAllSession()
////        System.out.println(sessionService.getAllSession());
//
//        //giveAuthority()
////        sessionService.giveAuthority(1);
//
//        //updateSession(): 测试修改主键值为2的场次信息
////        Session session = sessionService.getSessionBySessionId(2);
////        session.setUserNumber(11);
////        sessionService.updateSession(session);
//
        //deleteBySessionId():删除场次信息
        System.out.println(sessionService.deleteBySessionId(1));
//
//        //updateSessionState():修改场次状态
//        sessionService.updateSessionState(2);

    }
}
