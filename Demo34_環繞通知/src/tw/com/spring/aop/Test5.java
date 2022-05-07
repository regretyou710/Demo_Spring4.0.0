package tw.com.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

public class Test5 {

	public static void main(String[] args) {
		// 環繞通知測試
		ApplicationContext ac = new ClassPathXmlApplicationContext("aop.xml");
		ICalculator cal = ac.getBean("calculatorImpl", ICalculator.class);
		// 沒有例外時
		System.out.println(cal.div(4, 2));

		// 出現例外時，返回通知不會執行
		// System.out.println(cal.div(1, 0));
	}
}
