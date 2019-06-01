package Spring.jdbc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAOP {
	
	@Test
	public void test() {
		ApplicationContext context = new ClassPathXmlApplicationContext("beanc3p0.xml");
		UserService us = (UserService) context.getBean("userService");
		us.add();
	}

}
