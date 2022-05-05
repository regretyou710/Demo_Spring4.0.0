package tw.com.spring.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//�N�z��H
public class ProxyUtil {
	/**
	 * �ʺA�N�z:�i�H������ؼй�H�Ыؤ@�ӥN�z��H
	 */

	// �ؼй�H
	private CalculatorImpl cal;

	// ����ؼй�H
	// private Object cal;

	// �g�@�Ӥ�k�Ө��o�N�z��H
	public Object getProxy() {
		// �ϥ�jdk����Proxy�ӳЫؤ@�ӷs���N�z��H

		// 1.proxy�ݭn���[������proxy�M��e�����@�ΦP�@�����[����
		// 2.���o�ؼй�H�n��@���Ҧ�����(�@��h��)
		// 3.����B�z��:�N�z��H�p���{�ؼй�H���\�� �ؼй�H���\��=�����եΥؼй�H���\��(�öǤJ�ؼй�H���\�઺�޼�)�A�i�O�ҵ��G�@�P��
		ClassLoader loader = this.getClass().getClassLoader();
		Class[] interfaces = cal.getClass().getInterfaces();
		return Proxy.newProxyInstance(loader, interfaces, new InvocationHandler() {
			// �w�q��k�Ӧp�����
			// �Ѽ�1.�N�z��H
			// �Ѽ�2.�N�z��H�n�h��{�ؼй�H����k�A(��k������̿�󪫥�A������~��եΤ�k)
			// �Ѽ�3.�N�z��H�n�h��{�ؼй�H����k�Ѽ�
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				// �ӥN�z��H�n�h��{�ؼй�H����k=�N�z��H�h��������ؼй�H����k
				return method.invoke(cal, args);// ��^���G = �����k�O�Ӧۥؼй�H�M�Ѽ�
			}
		});
	}
}
