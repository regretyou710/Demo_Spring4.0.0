package tw.com.spring.proxy;

public class MyLogger {
	// 撰寫一個在調用計算方法之前後的日誌訊息
	// 調用計算方法之前訊息:顯示方法名稱和傳入參數
	// 調用計算方法之後訊息:顯示方法名稱和計算結果
	// 把公共方法(又稱切面關注點，非業務邏輯code)從某(些)方法中抽取出來放到一個類裡面，而這個類就叫"切面"
	// 當切面關注點存放到切面中，此時稱作"通知"
	// 切面關注點從某(些)方法中抽取出來的位置稱作"連接點"
	// 什麼情況下才能把切面作用到目標對象中稱作"切入點"
	public static void before(String methodName, String args) {
		System.out.println("調用方法前  方法名稱:" + methodName + ",方法參數:" + args);
	}

	public static void after(String methodName, Object result) {
		System.out.println("調用方法後  方法名稱:" + methodName + ",方法結果:" + result);
	}

	public static void throwing() {
		System.out.println("出現異常..");
	}
}
