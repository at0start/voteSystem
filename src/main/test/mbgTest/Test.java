package mbgTest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author 一个糟老头子
 * @createDate 2019/7/16-14:22
 */
public class Test {
    @org.junit.Test
    public void testDataSources() throws SQLException {
        ApplicationContext ac= new ClassPathXmlApplicationContext("classpath:spring.xml");
        DataSource dataSource = ac.getBean(DataSource.class);
        System.out.println(dataSource.getConnection());
    }
}

