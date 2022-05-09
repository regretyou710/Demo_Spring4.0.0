package tw.com.book;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import tw.com.book.controller.BookController;

public class Test {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("book.xml");
		BookController bookController = ac.getBean("bookController", BookController.class);
		bookController.buyBook();

//		購買第一次的時候
//		庫存10-1=9
//		餘額80-50=30
//		
//		購買第二次的時候，存在事務問題
//		庫存9-1=8
//		餘額30不夠買
//		因為餘額不足，所有交易事務應該回滾。但庫存卻扣成功
	}

}
