package tw.com.ioc.life;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("life.xml");
		Person p1 = ac.getBean("person", Person.class);

		// step3��step5���|�۰ʳQ�եΡA���z�L�O����H�ե�
		// �b�t�m��bean���Ҥ���init-method��destroy-method�w��k�W��
		System.out.println(p1);

		// �e�������ɽե�destroy
		ac.close();
	}

}
