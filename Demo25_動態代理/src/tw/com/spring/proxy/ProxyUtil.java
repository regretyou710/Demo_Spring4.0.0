package tw.com.spring.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ProxyUtil {
	/**
	 * 動態代理:可以為任何目標對象創建一個代理對象
	 */

	// 目標對象
	private CalculatorImpl cal;

	// 任何目標對象
	// private Object cal;

	// 為屬性賦值:1.建構函數 2.get&set方法
	public ProxyUtil(CalculatorImpl cal) {
		this.cal = cal;
	}

	// 寫一個方法來取得代理對象
	public Object getProxy() {
		// 使用jdk中的Proxy來創建一個新的代理對象

		// 1.proxy需要類加載器讓proxy和當前的類共用同一個類加載器
		// 2.取得目標對象要實作的所有介面(一到多個)
		// 3.執行處理器:代理對象如何實現目標對象的功能 目標對象的功能=直接調用目標對象的功能(並傳入目標對象的功能的引數)，可保證結果一致性
		ClassLoader loader = this.getClass().getClassLoader();// 獲取當前類的類加載器，用來加載代理對象所屬類
		Class[] interfaces = cal.getClass().getInterfaces();// 獲取目標對象實現的所有介面的Class，代理類會和目標類實現相同的介面，最終透過代理對象實現功能
		return Proxy.newProxyInstance(loader, interfaces, new InvocationHandler() {// 代理對象實現功能的方式
			// 定義方法該如何執行
			// 參數1.代理對象
			// 參數2.代理對象要去實現目標對象的方法，(方法的執行依賴於物件，有物件才能調用方法)
			// 參數3.代理對象要去實現目標對象的方法參數
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

				try {

					// System.out.println("調用方法前");

					MyLogger.before(method.getName(), Arrays.toString(args));// Arrays.toString(args)->將陣列轉換成字串

					// 而代理對象要去實現目標對象的方法=代理對象去直接執行目標對象的方法
					Object result = method.invoke(cal, args);// 返回結果 = 執行方法是來自目標對象和參數

					MyLogger.after(method.getName(), result);

					// System.out.println("調用方法結果:" + result);
					// System.out.println("調用方法後");
					return result;
				} catch (Exception e) {
					e.getStackTrace();
					// MyLogger.throwing();
				} finally {
					System.out.println("日誌結束..");
				}
				
				return null;
			}
		});
	}
}
