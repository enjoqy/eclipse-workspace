package Spring.myservice;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAOP {
	
	@Test
	public void test() {
		ApplicationContext context = new ClassPathXmlApplicationContext("beanaccount.xml");
		OrdersService os = (OrdersService) context.getBean("ordersService");
		os.accountMoney();
	}

}
