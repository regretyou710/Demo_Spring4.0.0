package tw.com.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

public class Test2 {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("aop.xml");
		ICalculator cal = ac.getBean("calculatorImpl", ICalculator.class);// AOP底層使用的是動態代理，因為動態代理是取得目標對象的介面來進行AOP所以getBean()要填入"介面.class"
		// 因為spring容器實現AOP，裡面的功能已經被AOP使用動態代理幫助創建代理對象
		// System.out.println(cal.getClass().getName());// com.sun.proxy.$Proxy11

		// 範例:兩個切面作用在一個目標對象，觀察兩個切的通知優先順序

		// 沒有例外時
		System.out.println(cal.div(4, 2));

		// 出現例外時，返回通知不會執行
		// System.out.println(cal.div(1, 0));
	}

}
