package tw.com.spring.ioc.userModel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import tw.com.spring.ioc.userModel.service.IUserService;
import tw.com.spring.ioc.userModel.service.impl.UserServiceImpl;

/**
 * 基於註解的組件化管理：
 * @Component,@Controller（控制層）,@Service（業務層）,@Repository（持久層）
 * 以上四個註解功能完全相同，不過在實際開發中，要在實現不同功能的類上加上相應的註解
 * 完成組件化管理的過程：
 * 1、在需要被spring管理的類上加上相應註解
 * 2、在配置文件中通過<context:component-scan>對所設置的包結構進行掃描，就會將加上註解的類，作為spring的組件進行加載
 * 組件：指spring中管理的bean
       作為spring的組件進行加載：會自動在spring的配置文件中生成相對應的bean，這些bean的id會以類的首字母小寫為值；
       也可以通過@Controller("beanId")為自動生成的bean指定id
 * 自動裝配：在需要賦值的非字面量屬性上，加上@Autowired，就可以在spring容器中，通過不同的方式匹配到相對應的bean
 * @Autowired裝配時，會默認使用byType的方式，此時要求spring容器中只有一個能夠為其賦值
 * 當byType實現不了裝配時，會自動切換到byName，此時要求spring容器中，有一個bean的id和屬性名一致
 * 若自動裝配時，匹配到多個能夠複製的bean，可使用@Qualifier(value="beanId")指定使用的bean
 * @Autowired和@Qualifier(value="beanId")可以一起作用域一個帶形參的方法上，此時，@Qualifier(value="beanId")
 * 所指定的bean作用於形參
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
