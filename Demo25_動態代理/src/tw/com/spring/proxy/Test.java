package tw.com.spring.proxy;

public class Test {

	public static void main(String[] args) {
		ProxyUtil proxyUtil = new ProxyUtil(new CalculatorImpl());
				
		/*
		 * 如果轉型成目標對象，因為代理對象知道目標對象要實現的功能是透過實現相同的介面來實現的 
		 * 而具體的類(實現類、目標對象)裡面還可以定義自己要實現的功能，例如目標對象除了加減乘除 
		 * 還有其他功能換句話說目標對象除了介面定義的功能之外的功能代理對象是不知道的，所以轉型
		 * 成目標對象且調用代理對象不知道的功能，代理對象會不知道如何執行		
		 */
		// 取得代理對象
		ICalculator proxy = (ICalculator) proxyUtil.getProxy();// 因為目標對象最終實現的方法是來自介面，所以明確向下轉型成介面
		int i = proxy.add(1, 1);
		System.out.println(i);
	}

}
