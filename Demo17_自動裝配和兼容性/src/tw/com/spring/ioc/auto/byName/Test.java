package tw.com.spring.ioc.auto.byName;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac = new ClassPathXmlApplicationContext("autoByName.xml");
		Emp e1 = ac.getBean("emp", Emp.class);

		// ref��bean id�Pemp��ref�������ݩʦW�ٶi�����A�p�G�@�P�h�۰ʽ��
		System.out.println(e1);
	}

}
