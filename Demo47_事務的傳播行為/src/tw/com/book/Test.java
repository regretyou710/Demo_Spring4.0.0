package tw.com.book;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import tw.com.book.controller.BookController;

public class Test {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("book.xml");
		BookController bookController = ac.getBean("bookController", BookController.class);
		bookController.buyBook();

//		情境:對同一本書購買多次
//		購買第一次的時候
//		庫存10-1=9
//		餘額80-50=30
//		
//		購買第二次的時候，因為BookServiceImpl中的buyBook方法加上@Transactional
//		庫存9-1=8
//		餘額30不夠買
//		因為餘額不足，交易事務回滾
//		庫存9
//		餘額30不夠買
	}

}
