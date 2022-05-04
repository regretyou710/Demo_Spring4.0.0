package tw.com.spring.ioc.userModel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import tw.com.spring.ioc.userModel.service.IUserService;
import tw.com.spring.ioc.userModel.service.impl.UserServiceImpl;

/**
 * �����Ѫ��ե�ƺ޲z�G
 * @Component,@Controller�]����h�^,@Service�]�~�ȼh�^,@Repository�]���[�h�^
 * �H�W�|�ӵ��ѥ\�৹���ۦP�A���L�b��ڶ}�o���A�n�b��{���P�\�઺���W�[�W����������
 * �����ե�ƺ޲z���L�{�G
 * 1�B�b�ݭn�Qspring�޲z�����W�[�W��������
 * 2�B�b�t�m��󤤳q�L<context:component-scan>��ҳ]�m���]���c�i�汽�y�A�N�|�N�[�W���Ѫ����A�@��spring���ե�i��[��
 * �ե�G��spring���޲z��bean
       �@��spring���ե�i��[���G�|�۰ʦbspring���t�m��󤤥ͦ��۹�����bean�A�o��bean��id�|�H�������r���p�g���ȡF
       �]�i�H�q�L@Controller("beanId")���۰ʥͦ���bean���wid
 * �۰ʸ˰t�G�b�ݭn��Ȫ��D�r���q�ݩʤW�A�[�W@Autowired�A�N�i�H�bspring�e�����A�q�L���P���覡�ǰt��۹�����bean
 * @Autowired�˰t�ɡA�|�q�{�ϥ�byType���覡�A���ɭn�Dspring�e�����u���@�ӯ��������
 * ��byType��{���F�˰t�ɡA�|�۰ʤ�����byName�A���ɭn�Dspring�e�����A���@��bean��id�M�ݩʦW�@�P
 * �Y�۰ʸ˰t�ɡA�ǰt��h�ӯ���ƻs��bean�A�i�ϥ�@Qualifier(value="beanId")���w�ϥΪ�bean
 * @Autowired�M@Qualifier(value="beanId")�i�H�@�_�@�ΰ�@�ӱa�ΰѪ���k�W�A���ɡA@Qualifier(value="beanId")
 * �ҫ��w��bean�@�Ω�ΰ�
 *
 */

//@Controller(value="aaa")
//@Controller("aaa")
@Controller
public class UserController {

	// private IUserService iUserService = new UserServiceImpl();

	@Autowired
	private IUserService iUserService;

	public UserController() {
		System.out.println("UserController");
	}

	public void addUser() {
		iUserService.addUser();
	}

}
