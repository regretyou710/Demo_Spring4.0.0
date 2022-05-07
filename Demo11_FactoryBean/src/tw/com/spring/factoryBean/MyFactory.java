package tw.com.spring.factoryBean;

import org.springframework.beans.factory.FactoryBean;

public class MyFactory implements FactoryBean<Car> {

	@Override
	public Car getObject() throws Exception {
		// TODO Auto-generated method stub
		Car car = new Car();
		car.setBrand("奧迪");
		car.setPrice(20000.0);
		return car;
	}

	@Override
	public Class<?> getObjectType() {
		// TODO Auto-generated method stub
		return Car.class;
	}

	@Override
	public boolean isSingleton() {
		// TODO Auto-generated method stub
		return false;
	}

}
