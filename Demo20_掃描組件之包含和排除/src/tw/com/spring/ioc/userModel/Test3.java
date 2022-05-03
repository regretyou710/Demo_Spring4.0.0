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

		// Spring�Һ޲z��bean�q�{����ҡA��e����l�������c�y��Ʒ|�����Q�եγЫع�H
		// �B�J1. �]��bean����H�����Ω�H���i���ҤƩҥH�nSpring�����ѭn���Ѧb�@�����W
		// �B�J2. �z�L���ұ��y���Ѫ���
		// ���ޤJaop jar�]

		// ����:�t�m���u���ycontroller�ؿ�
		// �ھڵ��ѱư�
		// �B�J1. <context:component-scan>�����ݩ�:use-default-filters�]��true���q�{
		// �B�J2. �[�J<context:exclude-filter>�l����
		UserController uc = ac.getBean("userController", UserController.class);
		System.out.println(uc);

		IUserService us = ac.getBean("userServiceImpl", UserServiceImpl.class);
		System.out.println(us);

		IUserDAO ud = ac.getBean("userDAOImpl", UserDAOImpl.class);
		System.out.println(ud);
	}

}
