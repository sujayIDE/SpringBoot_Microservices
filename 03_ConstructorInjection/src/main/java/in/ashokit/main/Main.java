package in.ashokit.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.ashokit.bean.UserService;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("config.xml");
		
		Object o=context.getBean("us");
		
		UserService userService=(UserService) o;
		
		userService.print("Ashok");

	}

}
