package tw.com.spring.aopxml;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
//@Aspect// 因為透過xml配置就不須用註解方式
public class MyLogger {

	public void before() {
		System.out.println("前置通知");
	}
	
	public void after() {
		System.out.println("後置通知");
	}
}
