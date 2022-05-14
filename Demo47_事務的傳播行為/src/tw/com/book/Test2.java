package tw.com.book;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import tw.com.book.controller.BookController;

public class Test2 {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("book.xml");
		BookController bookController = ac.getBean("bookController", BookController.class);
		bookController.checkOut();

//		情境:買多本書
//		因為沒有對checkOut方法加上@Transactional
//		所以方法中的操作(buyBook)都是單獨存在，而不是同一個事務中
//		所以不會因為不能買第二本書而回滾第一次及第二次的事務
//		第一本書能買成功
//		第二本書不能買成功
		
//		在CashierServiceImple類上加上@Transactional是對類中所有方法都有效
//		此時checkOut操作(buyBook)都是在同一個事務中
//		所以有一步執行失敗所有的操作全部回滾
		
//		若將BookServiceImpl類中的@Transactional的屬性propagation設置為Propagation.REQUIRES_NEW
//		表示不使用CashierServiceImpl事務傳播，所以buyBook方法每一次操作都視為單獨的事務，最終不會因為不能買
//		第二本書而回滾第一次及第二次的事務
	}

}
