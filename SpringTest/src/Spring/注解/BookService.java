package Spring.×¢½â;

import javax.annotation.Resource;

public class BookService {
	
	@Resource(name="bookDao")
	private BookDao bookDao;
	
	@Resource(name="orderDao")
	private OrderDao orderDao;
	
	public void add() {
		System.out.println("bookService.........");
		
		bookDao.add();
		orderDao.add();
		
	}

}
