package cn.itcast.cxf.ws.server;

import javax.xml.ws.Endpoint;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

import cn.itcast.cxf.service.IUserService;
import cn.itcast.cxf.service.impl.UserServiceImpl;

public class WS_Server {

	/*
	 * public static void main(String[] args) { //1.创建服务实现类对象 IUserService
	 * userService=new UserServiceImpl(); //定义服务地址 String
	 * address="http://localhost:9999/userService"; //3.发布服务
	 * Endpoint.publish(address, userService); //4.打印信息
	 * System.out.println("服务器端已经启动!"); }
	 */

	public static void main(String[] args) {
		// 1：创建服务实现类 对象
		IUserService userService = new UserServiceImpl();
		// 2：定义服务地址
		String address = "http://localhost:9999/userService";
		JaxWsServerFactoryBean factoryBean = new JaxWsServerFactoryBean();
		factoryBean.setServiceBean(userService);
		factoryBean.setAddress(address);

		// 打印日志，可以让我们看到传输的数据，SOAP协议=HTTP协议+XML数据
		factoryBean.getInInterceptors().add(new LoggingInInterceptor());
		factoryBean.getOutInterceptors().add(new LoggingOutInterceptor());
		// 3：发布服务
		factoryBean.create();
		// 4：打印信息
		System.out.println("helloService 服务已经启动 ...");

	}

}
