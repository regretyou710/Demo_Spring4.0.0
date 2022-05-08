package tw.com.spring.jdbctemplate;

import static org.junit.Assert.*;

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
		// jdbcTemplate.queryForObject(sql, requiredType);// 用來獲取單個的值
		// jdbcTemplate.queryForObject(sql, rowMapper);// 用來獲取單條數據

		// 透過通配符獲取單條數據並映射到Entity(實體類)，將資料表欄位名或別名與實體類屬性進行映射
		String sql = "select eid, ename, age, sex from emp where eid = ?";
		RowMapper<Emp> rowMapper = new BeanPropertyRowMapper<>(Emp.class);// 滑鼠選取RowMapper類，按ctrl+t查看繼承或實現類

		// ctrl+1，快捷鍵提示，使用assign可快速建立變數
		Emp queryForObject = jdbcTemplate.queryForObject(sql, new Object[] { 1 }, rowMapper);
		System.out.println(queryForObject);
	}

	@Test
	public void testQueryForObject2() {
		String sql = "select count(*) from emp";

		// 型參2:聚合函數返回結果的類型，不能寫int.class，因為從數據庫如果返回的是null無法賦值給int數據類型
		Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
		System.out.println(count);
	}
}
