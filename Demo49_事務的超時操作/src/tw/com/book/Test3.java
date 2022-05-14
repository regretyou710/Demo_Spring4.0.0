package tw.com.book;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import tw.com.book.controller.BookController;

public class Test3 {

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
		
//		事務超時操作:
//		若在CashierServiceImpl類的@Transactional沒加上屬性timeout則執行checkOut()會拋java.lang.RuntimeException例外
//		若加上timeout則會Transaction timed out拋例外
//		表示checkOut方法中的事務若超時則會強制回滾
	}

}
