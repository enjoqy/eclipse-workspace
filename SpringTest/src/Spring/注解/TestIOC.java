package Spring.×¢½â;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestIOC {
	
	@Test
	public void test() {
		ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
		BookService bs = (BookService) context.getBean("bookService");
		bs.add();
		
	}

}
