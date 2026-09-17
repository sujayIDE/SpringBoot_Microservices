package in.ashokit.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("config.xml");
		
		Object o=context.getBean("hw");
		
		Hello hello=(Hello)o;
		
		hello.display();
	}

}
