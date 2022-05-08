package tw.com.spring.jdbctemplate;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class TestJdbcTemplate {
	ApplicationContext ac = new ClassPathXmlApplicationContext("jdbc.xml");
	JdbcTemplate jdbcTemplate = ac.getBean("jdbcTemplate", JdbcTemplate.class);

	@Test
	public void test() {
		// System.out.println(jdbcTemplate.getDataSource());

		// 下列操作相當於WEB層中的DAO層
		// 1.一般操作
		// jdbcTemplate.update("insert into emp values(1, '張三', 23, '男' )");

		// 2.透過通配符操作
		String sql = "insert into emp values(?, ?, ?, ?)";
		jdbcTemplate.update(sql, 2, "李四", 24, "女");

	}
}
