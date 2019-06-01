package Spring.AOP.×¢½â;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAOP {
	
	@Test
	public void test() {
		ApplicationContext context = new ClassPathXmlApplicationContext("beanAop×¢½â.xml");
		Book book = (Book) context.getBean("book");
		book.add();
	}

}
