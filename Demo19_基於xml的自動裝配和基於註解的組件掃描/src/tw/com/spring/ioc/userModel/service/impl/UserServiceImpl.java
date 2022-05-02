package tw.com.spring.ioc.userModel.service.impl;

import org.springframework.stereotype.Repository;

import tw.com.spring.ioc.userModel.service.IUserService;

@Repository
public class UserServiceImpl implements IUserService {

	public UserServiceImpl() {
		System.out.println("UserServiceImpl");
	}
}
