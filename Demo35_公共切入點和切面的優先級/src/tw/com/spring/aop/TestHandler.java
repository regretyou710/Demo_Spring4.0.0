package tw.com.spring.aop;

import org.springframework.stereotype.Component;

@Component// 目標對象也須加入註解做為spring的組件AOP才會有作用
public class TestHandler {

	public void test() {
		System.out.println("測試切入點表達式");
	}
}
