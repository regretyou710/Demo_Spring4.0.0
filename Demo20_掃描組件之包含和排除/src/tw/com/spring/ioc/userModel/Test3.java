package tw.com.spring.ioc.userModel;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import tw.com.spring.ioc.userModel.controller.UserController;
import tw.com.spring.ioc.userModel.dao.IUserDAO;
import tw.com.spring.ioc.userModel.dao.impl.UserDAOImpl;
import tw.com.spring.ioc.userModel.service.IUserService;
import tw.com.spring.ioc.userModel.service.impl.UserServiceImpl;

public class Test3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac = new ClassPathXmlApplicationContext("user2.xml");

		// Spring所管理的bean默認為單例，當容器初始化類的構造函數會直接被調用創建對象
		// 步驟1. 因為bean不能以介面或抽象類進行實例化所以要Spring的註解要註解在一般類上
		// 步驟2. 透過標籤掃描註解的類
		// 須引入aop jar包

		// 測試:配置文件只掃描controller目錄
		// 根據註解排除
		// 步驟1. <context:component-scan>標籤屬性:use-default-filters設為true或默認
		// 步驟2. 加入<context:exclude-filter>子標籤
		UserController uc = ac.getBean("userController", UserController.class);
		System.out.println(uc);

		IUserService us = ac.getBean("userServiceImpl", UserServiceImpl.class);
		System.out.println(us);

		IUserDAO ud = ac.getBean("userDAOImpl", UserDAOImpl.class);
		System.out.println(ud);
	}

}
