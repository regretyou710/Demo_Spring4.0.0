package tw.com.ioc.life;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("life.xml");
		Person p1 = ac.getBean("person", Person.class);

		// step3及step5不會自動被調用，須透過別的對象調用
		// 在配置檔bean標籤中的init-method及destroy-method定方法名稱
		System.out.println(p1);

		// 容器關閉時調用destroy
		ac.close();
	}

}
