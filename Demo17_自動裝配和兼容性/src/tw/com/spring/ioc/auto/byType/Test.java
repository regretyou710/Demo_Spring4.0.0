package tw.com.spring.ioc.auto.byType;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac = new ClassPathXmlApplicationContext("autoByType.xml");
		Emp e1 = ac.getBean("emp", Emp.class);
		
		// 在配置文件中有一個ref對象能為emp的ref類型賦值就能夠自動裝配
		// 兼容性:
		//  1. 用子類可以對父類賦值
		//  2. 用實現類可以對介面賦值
		System.out.println(e1);
	}

}
