package tw.com.spring.model;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBySpring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 初始化
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

		// 透過bean ID取得class
		Person person = (Person) ac.getBean("person");
		System.out.println(person);
	}

}
