package Spring���;

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
		
		//set����ע������
//		Book book = (Book)context.getBean("book");
//        book.add();	
		
		//set����ע�����
//		UserService userService = (UserService)context.getBean("userService"); 
//		userService.add();
		
		Person person = (Person) context.getBean("person");
		person.test();
		
		
	}

}
