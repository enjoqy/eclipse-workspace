package Spring.myservice;

import org.springframework.transaction.annotation.Transactional;

import Spring.mydao.OrdersDao;

//@Transactional
public class OrdersService {
	
	private OrdersDao ordersDao;

	public void setOrdersDao(OrdersDao ordersDao) {
		this.ordersDao = ordersDao;
	}
    /*
     * service�����߼��㣬dao���Ƕ����ݿ������
     */
	public void accountMoney() {
		
		ordersDao.lessMoney();
		
		int a= 1/0;
		
		ordersDao.moreMoney();
	}
}
