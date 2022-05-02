package tw.com.spring.ioc.userModel.dao.impl;

import org.springframework.stereotype.Service;

import tw.com.spring.ioc.userModel.dao.IUserDAO;

@Service
public class UserDAOImpl implements IUserDAO {

	public UserDAOImpl() {
		System.out.println("UserDATImpl");
	}
}
