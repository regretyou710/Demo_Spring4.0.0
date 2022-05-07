package tw.com.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

public class Test2 {

	public static void main(String[] args) {
		// 後置通知測試
		ApplicationContext ac = new ClassPathXmlApplicationContext("aop.xml");
		ICalculator cal = ac.getBean("calculatorImpl", ICalculator.class);
		// System.out.println(cal.div(1, 2));

		// 測試後置通知位於動態代理中哪一區
		// 1.方法執行前
		// 2.方法執行後
		// 3.catch內
		// 4.finally內
		System.out.println(cal.div(1, 0));
	}
}
