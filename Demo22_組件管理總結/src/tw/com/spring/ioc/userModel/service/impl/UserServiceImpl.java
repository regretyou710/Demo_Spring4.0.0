package tw.com.spring.ioc.userModel.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import tw.com.spring.ioc.userModel.dao.IUserDAO;
import tw.com.spring.ioc.userModel.dao.impl.UserDAOImpl;
import tw.com.spring.ioc.userModel.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	// private IUserDAO iUserDAO = new UserDAOImpl();
	
/*
	@Autowired
	@Qualifier(value = "userDAOMyBatisImpl")
	private IUserDAO iUserDAO;
	
	public void setIUserDAO(IUserDAO iUserDAO) {
		this.iUserDAO = iUserDAO;
	}
*/
	
	
	// Autowired�]�i�H���Ѧb��k�W�÷f�tQualifier
	private IUserDAO iUserDAO;
	
	@Autowired
	@Qualifier(value = "userDAOMyBatisImpl")// �o�ӵ��ѬO�@�Ω�setIUserDAO�Ѽ�(�N���w��bean�@����Ѫ`�J)�A�P��k�W�L��
	public void setIUserDAO(IUserDAO iUserDAO) {
		this.iUserDAO = iUserDAO;
	}
	
	public UserServiceImpl() {
		System.out.println("UserServiceImpl");
	}

	@Override
	public void addUser() {
		iUserDAO.addUser();
	}
}
