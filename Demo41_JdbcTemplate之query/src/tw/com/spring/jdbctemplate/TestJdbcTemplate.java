package tw.com.spring.jdbctemplate;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class TestJdbcTemplate {
	ApplicationContext ac = new ClassPathXmlApplicationContext("jdbc.xml");
	JdbcTemplate jdbcTemplate = ac.getBean("jdbcTemplate", JdbcTemplate.class);

	@Test
	public void testQueryForObject() {
		String sql = "select eid, ename, age, sex from emp";
		RowMapper<Emp> rowMapper = new BeanPropertyRowMapper<>(Emp.class);// 滑鼠選取RowMapper類，按ctrl+t查看繼承或實現類

		// ctrl+1，快捷鍵提示，使用assign可快速建立變數
		List<Emp> query = jdbcTemplate.query(sql, rowMapper);
		for (Emp e : query) {
			System.out.println(e);
		}
	}
}
