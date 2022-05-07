package tw.com.spring.ioc.userModel.dao.impl;

import org.springframework.stereotype.Repository;

import tw.com.spring.ioc.userModel.dao.IUserDAO;

@Repository
public class UserDAOMyBatisImpl implements IUserDAO{

	@Override
	public void addUser() {
		System.out.println("UserDAOMyBatisImpl:新增成功!");		
	}

}
