package tw.com.spring.jdbctemplate;

import static org.junit.Assert.*;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class TestJdbcTemplate {
	ApplicationContext ac = new ClassPathXmlApplicationContext("jdbc.xml");
	JdbcTemplate jdbcTemplate = ac.getBean("jdbcTemplate", JdbcTemplate.class);

	@Test
	public void testUpdate() {
		// System.out.println(jdbcTemplate.getDataSource());

		// 下列操作相當於WEB層中的DAO層
		// 單筆操作
		// 1.一般操作
		// jdbcTemplate.update("insert into emp values(1, '張三', 23, '男' )");

		// 2.透過通配符操作
		String sql = "insert into emp values(?, ?, ?, ?)";
		jdbcTemplate.update(sql, 2, "李四", 24, "女");
	}

	@Test
	public void testBatchUpdate() {
		// 批量新增
		String sql = "insert into emp values(?, ?, ?, ?)";
		List<Object[]> list = new ArrayList<>();
		list.add(new Object[] { 1, "user1", 18, "男" });
		list.add(new Object[] { 2, "user2", 19, "女" });
		list.add(new Object[] { 3, "user3", 20, "男" });

		jdbcTemplate.batchUpdate(sql, list);
	}

	@Test
	public void testUpdateForDel() {
		jdbcTemplate.update("delete from emp");
	}

	@Test
	public void testUpdateForUpdate() {
		// 透過單筆操作批量(where in)

		// 這種方式會交易失敗，因為實參字串前後會自動加上單引號，所以使用where in操作批量時不可以用通配符
		// like也不可使用通配符
		// String sql = "update emp set age = 25 where eid in (?)";
		// System.out.println(jdbcTemplate.update(sql, "1,3"));

		// 使用字串拼接方式
		String args = "1,2,3";
		String sql = String.format("update emp set age = 25 where eid in (%s)", args);
		jdbcTemplate.update(sql);

	}
}
