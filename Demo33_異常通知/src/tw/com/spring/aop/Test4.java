package tw.com.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

public class Test4 {

	public static void main(String[] args) {
		// 異常通知測試
		ApplicationContext ac = new ClassPathXmlApplicationContext("aop.xml");
		ICalculator cal = ac.getBean("calculatorImpl", ICalculator.class);		
		System.out.println(cal.div(1, 0));
	}
}
