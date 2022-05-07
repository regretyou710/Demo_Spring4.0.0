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
	
	
	// Autowired也可以註解在方法上並搭配Qualifier
	private IUserDAO iUserDAO;
	
	@Autowired
	@Qualifier(value = "userDAOMyBatisImpl")// 這個註解是作用於setIUserDAO參數(將指定的bean作為實參注入)，與方法名無關
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
