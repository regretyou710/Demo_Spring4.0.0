package tw.com.spring.model;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBySpring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// ��l��
		// �Ϯg����z�Lclass���L�ѫغc���ͦ���ҹ�H
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

		// 1.�z�Lbean ID���oclass
		// Person person = (Person) ac.getBean("person");

		// 2.�z�Lclass���oclass(bean�i�H���ΰt�mid�ݩ�)
		// �ϥΦ���k�����H�ɡA�n�Dspring�Һ޲z�����������ﹳ�u�঳�@��
		// Person person = ac.getBean(Person.class);

		// 3.�z�Lbean ID��class���oclass
		Person person = ac.getBean("person2", Person.class);

		System.out.println(person);
	}

}
