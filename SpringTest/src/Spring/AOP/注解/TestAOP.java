package Spring.AOP.ע��;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAOP {
	
	@Test
	public void test() {
		ApplicationContext context = new ClassPathXmlApplicationContext("beanAopע��.xml");
		Book book = (Book) context.getBean("book");
		book.add();
	}

}
