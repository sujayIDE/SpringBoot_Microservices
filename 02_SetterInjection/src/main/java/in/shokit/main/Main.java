package in.shokit.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.ashokit.bean.OrderService;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("config.xml");
		
		Object o=context.getBean("os");
		
		OrderService orderService=(OrderService)o;
		
		orderService.placeOrder();
	}

}
