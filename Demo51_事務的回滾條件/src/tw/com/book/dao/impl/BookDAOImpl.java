package tw.com.book.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import tw.com.book.dao.IBookDAO;
import tw.com.book.exception.MyException;

@Repository
public class BookDAOImpl implements IBookDAO {

//  在配置文件中表現為: 
//	<bean id="bookDAOImpl" class="tw.com.book.dao.impl.BookDAOImpl">
//		<property name="jdbcTemplate" ref="jdbcTemplate"></<property>
//	</bean>	
//	<bean id="jdbcTemplate"
//			class="org.springframework.jdbc.core.JdbcTemplate">
//			<!-- name相當於實例中宣告屬性的名稱 -->
//			<property name="dataSource" ref="dataSource"></property>
//	</bean>
//	...
//	
//	使用自動裝配:
//	<bean id="bookDAOImpl" class="tw.com.book.dao.impl.BookDAOImpl" autowire="byType">
//  </bean>

	@Autowired // @Autowired裝配時，會默認使用byType的方式，此時要求spring容器中只有一個能夠為其賦值
	JdbcTemplate jdbcTemplate;

	@Override
	public Integer queryPrice(String bid) {
		// 型參3:select price的數據類型
		return jdbcTemplate.queryForObject("select price from book where bid = ?", new Object[] { bid }, Integer.class);
	}

	@Override
	public void updateStock(String bid) {
		// 獲取該書籍的庫存
		Integer stock = jdbcTemplate.queryForObject("select st from stock where sid = ?", new Object[] { bid },
				Integer.class);

		if (stock <= 0)
			throw new RuntimeException();
		else
			jdbcTemplate.update("update stock set st = st -1 where sid = ?", bid);
	}

	@Override
	public void updateBalance(String uid, Integer price) {
		Integer balance = jdbcTemplate.queryForObject("select balance from userinfo where \"UID\" = ?",
				new Object[] { uid }, Integer.class);

		if (balance < price)
			throw new MyException("餘額不足!");
		else
			jdbcTemplate.update("update userinfo set balance = balance - ? where \"UID\" = ?", price, uid);
	}

}
