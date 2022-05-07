package tw.com.spring.model;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBySpring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 初始化
		// 反射機制透過class的無參建構式生成實例對象
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

		// 1.透過bean ID取得class
		// Person person = (Person) ac.getBean("person");

		// 2.透過class取得class(bean可以不用配置id屬性)
		// 使用此方法獲取對象時，要求spring所管理的此類型的對像只能有一個
		// Person person = ac.getBean(Person.class);

		// 3.透過bean ID及class取得class
		Person person = ac.getBean("person2", Person.class);

		System.out.println(person);
	}

}
