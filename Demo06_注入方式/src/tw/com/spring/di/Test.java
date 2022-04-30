package tw.com.spring.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans-di.xml");
		Student s1 = ac.getBean("s1", Student.class);
		System.out.println(s1);

		// 透過構造函數創建實例對象
		Student s2 = ac.getBean("s2", Student.class);
		System.out.println(s2);

		Student s3 = ac.getBean("s3", Student.class);
		System.out.println(s3);
	}

}
