package tw.com.spring.ioc.dataSource;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.druid.pool.DruidDataSource;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ApplicationContext ac = new ClassPathXmlApplicationContext("dataSource.xml");
			DruidDataSource druidDataSource = ac.getBean("dataSource", DruidDataSource.class);
			System.out.println(druidDataSource.getConnection());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
