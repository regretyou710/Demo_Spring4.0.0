package tw.com.book;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import tw.com.book.controller.BookController;

public class Test {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("book.xml");
		BookController bookController = ac.getBean("bookController", BookController.class);
		bookController.buyBook();

//		情境:對同一本書購買多次
//		為了讓buyBook不使用checkOut事務的傳播，所以
//		將buyBook@Transactional的propagation設置為Propagation.REQUIRES_NEW
//		以模擬餘額不足時仍會扣庫存(扣庫存的事務不回滾)(noRollbackFor = { MyExeception.class })
	}
}
