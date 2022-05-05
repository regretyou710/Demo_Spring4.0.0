package tw.com.spring.proxy;

public class Test {

	public static void main(String[] args) {
		ICalculator math = new CalculatorImpl();
		math.add(1, 1);
		math.sub(1, 1);
		math.mul(1, 1);
		math.div(1, 1);
	}

}
