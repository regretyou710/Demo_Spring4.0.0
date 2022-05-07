package tw.com.spring.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

// 存放橫切關注點的類->切面
@Component // AOP的核心也是依賴IOC，所以須將切面當作是spring的一個組件才會有作用
@Aspect // 註解當前的類為切面
public class MyLoggerAspect {

	/**
	 * 透過公共切入點集中控制切入點表達式
	 */
	@Pointcut(value="execution(* tw.com.spring.aop.*.*(..))")
	public void test() {
		
	}
	
	// 將橫切關注點抽取出來存放的類稱為通知類
	// 每一個功能(方法)稱為通知
	// 通知是作用於目標對象上的連接點
	// -------------------------------
	// 把公共方法(又稱切面關注點，非業務邏輯code)從某(些)方法中抽取出來放到一個類裡面，而這個類就叫"切面"
	// 當切面關注點存放到切面中，此時稱作"通知"
	// 切面關注點從某(些)方法中抽取出來的位置稱作"連接點";目標對象實現功能過程中的各個位置稱作"連接點"
	// 什麼情況下才能把切面作用到目標對象中稱作"切入點";切面中的通知應用於連接點的條件稱作"切入點"

	/**
	 * @Before:將方法標註為前置通知(方法執行之前加入到某一個功能) 
	 * value:切入點表達式(必須設置)	 
	 * 表達式:前置通知要作用到的功能(方法)
	 * 當Spring容器解析當前的切入點表達式時，執行前置通知的時候就會把方法的訊息封裝到JoinPoint
	 */
	//@Before(value = "execution(public int tw.com.spring.aop.CalculatorImpl.add(int, int))")// 切入點:切面的通知應用於連接點的條件 // 只有add()才有前置通知
	//@Before(value = "execution(public int tw.com.spring.aop.CalculatorImpl.*(int, int))")// 所有方法都有前置通知
	//@Before(value = "execution(* tw.com.spring.aop.CalculatorImpl.*(int, int))")//所有方法的修飾詞和返回類型都有前置通知
	@Before(value = "test()")// 在tw.com.proxy底下所有的類、所有方法的修飾詞和返回類型及任意參數都有前置通知
	//@Before(value = "execution(public void tw.com.spring.aop.TestHandler.test())")
	public void beforeMethod(JoinPoint joinPoint) {// 連接點:目標對象實現功能過程中的各個位置

		Object[] args = joinPoint.getArgs();// 獲取方法的參數
		String methodName = joinPoint.getSignature().getName();// 獲取方法的名稱
		System.out.println("前置通知  方法名稱:" + methodName + ", 方法參數:" + Arrays.toString(args));
	}
	
	/**
	 * @After:將方法標註為後置通知
	 * 經由div(1,0)方法測試，後置通知作用於方法的finally的區塊而非try區塊，不管有無異常都會執行
	 */
	@After(value = "test()")
	public void afterMethod() {
		System.out.println("後置通知");
	}

	/**
	 * @AfterReturning:將方法標註為返回通知
	 * 返回通知作用於方法之後，如果出現例外返回通知就不會有作用
	 * 可透過切入點表達式(returning)設定接收方法返回值的變數名稱，如要在通知方法中使用，afterReturningMethod的型參和變量名稱須相同
	 */
	@AfterReturning(value = "test()", returning = "result")
	public void afterReturningMethod(JoinPoint joinPoint, Object result) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("返回通知  方法名稱:" + methodName + ",方法結果:" + result);
	}
	
	/*
	 * @AfterThrowing:將方法標註為異常通知
	 * 返回通知執行拋出異常時，如果出現例外返回通知就不會有作用
	 * 可透過切入點表達式(throwing)設定接收方法返回的異常訊息，如要在通知方法中使用，afterThrowingMethod的型參和變量名稱須相同
	 * 在通知方法的參數列表設定具體的異常類型，來對指定的異常訊息進行操作
	 */	
	@AfterThrowing(value = "test()", throwing = "ex")
	public void afterThrowingMethod(ArithmeticException ex) {
		System.out.println("例外通知 :" + ex.getMessage());
	}
	
	/**
	 * @Around:將方法標註為環繞通知
	 * 環繞通知等同於在動態代理模式中的new InvocationHandler(){}所做的事情
	 * 環繞在方法的周圍
	 * 在環繞通知控制方法的執行，才可知道方法何時開始和結束
	 * 在代理對象實現目標對象的方法的時候須保證結果的一致性
	 * 環繞通知可與其他通知並存使用
	 */	
	//@Around(value = "execution(* tw.com.spring.aop.*.*(..))")
	public Object around(ProceedingJoinPoint joinPoint) {

		Object result = null;

		try {
			// 前置通知
			System.out.println("前置通知(環繞)");

			result = joinPoint.proceed();// 進行執行方法

			// 返回通知
			System.out.println("返回通知(環繞)");

			return result;
		} catch (Throwable e) {
			// 異常通知
			System.out.println("異常通知(環繞)");
			e.printStackTrace();
		} finally {
			// 後置通知
			System.out.println("後置通知(環繞)");
		}
		// return null ;//不可以返回null，因為加減乘除的返回值都是int
		return -1;
	}
}
