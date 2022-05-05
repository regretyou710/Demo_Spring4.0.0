package tw.com.spring.proxy;


public class CalculatorImpl implements ICalculator {

	@Override
	public int add(int x, int y) {
		System.out.println("method:" + Thread.currentThread().getStackTrace()[1].getMethodName() + ", arguments:x=" + x
				+ " y=" + y);
		
		int rs = x + y;

		System.out.println("method:" + Thread.currentThread().getStackTrace()[1].getMethodName() + ", result=" + rs);

		return rs;
	}

	@Override
	public int sub(int x, int y) {
		System.out.println("method:" + Thread.currentThread().getStackTrace()[1].getMethodName() + ", arguments:x=" + x
				+ " y=" + y);

		int rs = x - y;

		System.out.println("method:" + Thread.currentThread().getStackTrace()[1].getMethodName() + ", result=" + rs);

		return rs;
	}

	@Override
	public int mul(int x, int y) {
		System.out.println("method:" + Thread.currentThread().getStackTrace()[1].getMethodName() + ", arguments:x=" + x
				+ " y=" + y);

		int rs = x * y;

		System.out.println("method:" + Thread.currentThread().getStackTrace()[1].getMethodName() + ", result=" + rs);
		return rs;
	}

	@Override
	public int div(int x, int y) {
		System.out.println("method:" + Thread.currentThread().getStackTrace()[1].getMethodName() + ", arguments:x=" + x
				+ " y=" + y);

		int rs = x / y;
		
		System.out.println("method:" + Thread.currentThread().getStackTrace()[1].getMethodName() + ", result=" + rs);

		return rs;
	}

}
