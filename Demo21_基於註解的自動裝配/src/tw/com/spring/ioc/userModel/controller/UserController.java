package tw.com.spring.ioc.userModel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import tw.com.spring.ioc.userModel.service.IUserService;
import tw.com.spring.ioc.userModel.service.impl.UserServiceImpl;

@Controller
public class UserController {

	// private IUserService iUserService = new UserServiceImpl();

	// Autowired���ѬO�ݩ�byType
	// bean�ե�g�L���y���[�W���Ѫ����۰ʦb�t�m���ͦ��A�u�O�ݤ����A�ҥH�L�k�bbean�[�Wautowire�ݩʡC
	// �۰ʸ˰t:�bSpring���޲z�d�򤧤��A�ھڤ��P���������o���ݩʧ��@�ӯର�L��Ȫ���H�i���ȡC
	// �n�����Ѭ�Autowired���ݩʦ۰ʸ˰t��ȡA�@�w�n�O�ү�Spring�e����������@�ӹ�H�ର�L��ȡA�ܤ֦��@�ӹ�H�ର�L���
	@Autowired
	private IUserService iUserService;

	public UserController() {
		System.out.println("UserController");
	}

	public void addUser() {
		iUserService.addUser();
	}

}
