package tw.com.spring.ioc.userModel;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import tw.com.spring.ioc.userModel.controller.UserController;
import tw.com.spring.ioc.userModel.dao.IUserDAO;
import tw.com.spring.ioc.userModel.dao.impl.UserDAOImpl;
import tw.com.spring.ioc.userModel.service.IUserService;
import tw.com.spring.ioc.userModel.service.impl.UserServiceImpl;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac = new ClassPathXmlApplicationContext("user.xml");

		
		UserController uc = ac.getBean("userController", UserController.class);
		/*System.out.println(uc);
		
		IUserService us = ac.getBean("userServiceImpl", UserServiceImpl.class);
		System.out.println(us);

		IUserDAO ud = ac.getBean("userDAOImpl", UserDAOImpl.class);
		System.out.println(ud);
		*/
		
		// ��UserServiceImpl������iUserDAO�ݩʦb�t�m��󤤦����bean�i�H���L��Ȯɷ|����
		// �i�z�LQualifier���ѫ��wbean id�Ӫ`�J
		uc.addUser();
	}

}
