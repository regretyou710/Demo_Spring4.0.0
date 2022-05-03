package tw.com.spring.ioc.userModel.service.impl;

import org.springframework.stereotype.Service;
import tw.com.spring.ioc.userModel.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	public UserServiceImpl() {
		System.out.println("UserServiceImpl");
	}
}
