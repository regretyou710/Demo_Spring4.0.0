package tw.com.spring.ioc.userModel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import tw.com.spring.ioc.userModel.service.IUserService;
import tw.com.spring.ioc.userModel.service.impl.UserServiceImpl;

@Controller
public class UserController {

	// private IUserService iUserService = new UserServiceImpl();

	// Autowired註解是屬於byType
	// bean組件經過掃描後把加上註解的類自動在配置文件生成，只是看不見，所以無法在bean加上autowire屬性。
	// 自動裝配:在Spring的管理範圍之內，根據不同的策略為這個屬性找到一個能為他賦值的對象進行賦值。
	// 要為註解為Autowired的屬性自動裝配賦值，一定要保證能Spring容器中能夠有一個對象能為他賦值，至少有一個對象能為他賦值
	@Autowired
	private IUserService iUserService;

	public UserController() {
		System.out.println("UserController");
	}

	public void addUser() {
		iUserService.addUser();
	}

}
