package tw.com.ioc.scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 單例模式會在配置文件(容器)初始化時就被創建(不用等到調用getBean才創建)
		// 多例則是等到使用時(調用getBean)才創建
		ApplicationContext ac = new ClassPathXmlApplicationContext("scope.xml");
		Student s1 = ac.getBean("student", Student.class);
		Student s2 = ac.getBean("student", Student.class);

		// bean設置單例後對象只會創建一次，可透過無參建構函數輸出次數驗證
		System.out.println(s1);
		System.out.println(s2);
	}

}
