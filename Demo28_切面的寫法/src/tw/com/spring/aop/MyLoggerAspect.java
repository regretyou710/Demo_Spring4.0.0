package tw.com.spring.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

// 存放橫切關注點的類->切面
@Component // AOP的核心也是依賴IOC，所以須將切面當作是spring的一個組件才會有作用
@Aspect // 註解當前的類為切面
public class MyLoggerAspect {

	// 將橫切關注點抽取出來存放的類稱為通知類
	// 每一個功能(方法)稱為通知

	/**
	 * @Before:將方法指定為前置通知(方法執行之前加入到某一個功能) 
	 * value:切入點表達式
	 */
	@Before(value = "execution(public int tw.com.spring.aop.CalculatorImpl.add(int, int))") // 切入點:切面的通知應用於連接點的條件
	public void beforeMethod() {
		System.out.println("方法執行之前");
	}
}
