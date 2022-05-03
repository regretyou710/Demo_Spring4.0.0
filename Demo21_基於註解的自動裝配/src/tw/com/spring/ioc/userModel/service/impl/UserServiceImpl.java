package tw.com.spring.ioc.userModel.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.com.spring.ioc.userModel.dao.IUserDAO;
import tw.com.spring.ioc.userModel.dao.impl.UserDAOImpl;
import tw.com.spring.ioc.userModel.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	// private IUserDAO iUserDAO = new UserDAOImpl();

	@Autowired
	private IUserDAO iUserDAO;

	public UserServiceImpl() {
		System.out.println("UserServiceImpl");
	}

	@Override
	public void addUser() {
		iUserDAO.addUser();
	}
}
