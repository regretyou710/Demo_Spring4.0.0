package tw.com.spring.ioc.auto.byType;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac = new ClassPathXmlApplicationContext("autoByType.xml");
		Emp e1 = ac.getBean("emp", Emp.class);
		
		// �b�t�m��󤤦��@��ref��H�ରemp��ref������ȴN����۰ʸ˰t
		// �ݮe��:
		//  1. �Τl���i�H��������
		//  2. �ι�{���i�H�虜�����
		System.out.println(e1);
	}

}
