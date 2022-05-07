package tw.com.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

public class Test {

	public static void main(String[] args) {
		// 1.配置文件寫入<aop:aspectj-autoproxy>標籤
		// 2.將方法指定為前置通知
		// 3.寫入切入點表達式
		// 4.切面類(公共類)及目標對象寫上@Component
		// 5.配置文件寫入<context:component-scan>標籤

		ApplicationContext ac = new ClassPathXmlApplicationContext("aop.xml");
		ICalculator cal = ac.getBean("calculatorImpl", ICalculator.class);// AOP底層使用的是動態代理，因為動態代理是取得目標對象的介面來進行AOP所以getBean()要填入"介面.class"
		System.out.println(cal.add(1, 2));
	}

}
