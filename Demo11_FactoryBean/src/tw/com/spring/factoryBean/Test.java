package tw.com.spring.factoryBean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac = new ClassPathXmlApplicationContext("factoryBean.xml");
		Object car = ac.getBean("factory");
		System.out.println(car);
	}

}
