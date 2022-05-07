package tw.com.spring.aopxml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

public class Test {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("aop-xml.xml");
		ICalculator cal = ac.getBean("calculatorImpl", ICalculator.class);
		System.out.println(cal.div(4, 2));
	}

}
