package Spring¿ò¼Ü;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IOCTest {
	
	@Test
	public void testUser() {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
		User user = (User)context.getBean("user");
		System.out.println(user);
		user.add();
			
	}

}
