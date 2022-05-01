package tw.com.ioc.life;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

// bean��m�B�z��
public class AfterHandler implements BeanPostProcessor {

	// ��l�ƫe
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("step3. ��l�ƫe");

		Person p = (Person) bean;
		if (p.getSex().equals("�k"))
			p.setName("�i�L��");
		else
			p.setName("����");
		return p;
	}

	// ��l�ƫ�
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("step3. ��l�ƫ�");
		return bean;
	}

}
