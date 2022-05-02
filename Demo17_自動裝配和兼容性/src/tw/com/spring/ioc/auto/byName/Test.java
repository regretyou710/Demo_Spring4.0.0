package tw.com.spring.ioc.auto.byName;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac = new ClassPathXmlApplicationContext("autoByName.xml");
		Emp e1 = ac.getBean("emp", Emp.class);

		// ref的bean id與emp的ref類型的屬性名稱進行比較，如果一致則自動賦值
		System.out.println(e1);
	}

}
