package tw.com.ioc.scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ��ҼҦ��|�b�t�m���(�e��)��l�ƮɴN�Q�Ы�(���ε���ե�getBean�~�Ы�)
		// �h�ҫh�O����ϥή�(�ե�getBean)�~�Ы�
		ApplicationContext ac = new ClassPathXmlApplicationContext("scope.xml");
		Student s1 = ac.getBean("student", Student.class);
		Student s2 = ac.getBean("student", Student.class);

		// bean�]�m��ҫ��H�u�|�Ыؤ@���A�i�z�L�L�ѫغc��ƿ�X��������
		System.out.println(s1);
		System.out.println(s2);
	}

}
