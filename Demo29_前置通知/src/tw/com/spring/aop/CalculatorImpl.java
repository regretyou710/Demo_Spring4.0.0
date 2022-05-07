package tw.com.spring.aop;

import org.springframework.stereotype.Component;

@Component// 目標對象也須加入註解做為spring的組件AOP才會有作用
public class CalculatorImpl implements ICalculator {

	@Override
	public int add(int x, int y) {
		// System.out.println("前");// 非業務邏輯代碼->橫切關注點
		int rs = x + y;
		// System.out.println("後");// 非業務邏輯代碼->橫切關注點
		return rs;
	}

	@Override
	public int sub(int x, int y) {
		int rs = x - y;
		return rs;
	}

	@Override
	public int mul(int x, int y) {
		int rs = x * y;
		return rs;
	}

	@Override
	public int div(int x, int y) {
		int rs = x / y;
		return rs;
	}

}
