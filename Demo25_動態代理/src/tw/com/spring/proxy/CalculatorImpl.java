package tw.com.spring.proxy;

public class CalculatorImpl implements ICalculator {

	@Override
	public int add(int x, int y) {
		int rs = x + y;
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
