package tw.com.spring.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
//@Order(-1)
public class MyLoggerAspect2 {
	/**
	 * 測試在多個切面下的通知優先權
	 * 默認下會先執行第一個MyLoggerAspect，再執行MyLoggerAspect2
	 * 可透過@Order管理切面的優先權
	 * 括弧填寫整數，負整數和0等同沒有寫的意思是沒有效果，正整數越小優先權越高，默認值為int最大值
	 */
	@Before(value = "execution(* tw.com.spring.aop.*.*(..))")
	public void test() {
		System.out.println("MyLoggerAspect2前置通知");
	}
}

