package Spring.AOP;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAop {
	
	@Test
	public void test() {
		ApplicationContext context = new ClassPathXmlApplicationContext("beanAop.xml");
		Book book = (Book) context.getBean("book");
		book.add();
		
	}

}
