package tw.com.ioc.life;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

// bean後置處理器
public class AfterHandler implements BeanPostProcessor {

	// 初始化前
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("step3. 初始化前");

		Person p = (Person) bean;
		if (p.getSex().equals("男"))
			p.setName("張無忌");
		else
			p.setName("趙敏");
		return p;
	}

	// 初始化後
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("step3. 初始化後");
		return bean;
	}

}
