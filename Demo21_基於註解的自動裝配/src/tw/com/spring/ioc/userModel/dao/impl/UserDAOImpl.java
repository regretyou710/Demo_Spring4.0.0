package tw.com.spring.ioc.userModel.dao.impl;

import org.springframework.stereotype.Repository;
import tw.com.spring.ioc.userModel.dao.IUserDAO;

@Repository
public class UserDAOImpl implements IUserDAO {

	public UserDAOImpl() {
		System.out.println("UserDAOImpl");
	}

	@Override
	public void addUser() {
		System.out.println("新增成功!");
	}
}
