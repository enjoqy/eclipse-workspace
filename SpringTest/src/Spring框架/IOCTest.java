package Spring框架;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IOCTest {
	
	@Test
	public void testUser() {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
//		User user = (User)context.getBean("user");
//		System.out.println(user);
//		user.add();
		
		//set方法注入属性
//		Book book = (Book)context.getBean("book");
//        book.add();	
		
		//set方法注入对象
//		UserService userService = (UserService)context.getBean("userService"); 
//		userService.add();
		
		Person person = (Person) context.getBean("person");
		person.test();
		
		
	}

}
