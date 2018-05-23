package cn.itcast.cxf.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import cn.itcast.cxf.domain.Car;
import cn.itcast.cxf.domain.User;
import cn.itcast.cxf.service.IUserService;

@WebService(endpointInterface = "cn.itcast.cxf.service.IUserService", serviceName = "userService")
public class UserServiceImpl implements IUserService {

	@Override
	public String sayHello(String name) {

		return "helllo" + name;
	}

	@Override
	public List<Car> findCarByUser(User user) {
		// 这里本应该查询数据库的，为了演示，做一些假数据
		if ("xiaoming".equals(user.getUsername())) {
			List<Car> cars = new ArrayList<Car>();
			Car car1 = new Car();
			car1.setId(1);
			car1.setCarName("大众");
			car1.setPrice(200000d);
			cars.add(car1);

			Car car2 = new Car();
			car2.setId(2);
			car2.setCarName("现代");
			car2.setPrice(170000d);
			cars.add(car2);

			return cars;
		} else {
			return null;
		}

	}

}
