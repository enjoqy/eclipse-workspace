package com.huaihao.hibernate.test;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import com.huaihao.hibernate.utile.HibernateUtiles;

public class UserDemo {
	
	@Test
	public void addTest() {
//		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
//		sessionFactory = HibernateUtiles.getSessionFactory();
		
		session = HibernateUtiles.getSessionObject();
		tx = session.beginTransaction();
		
		User user = new User();
		user.setAdress("异次元");
		user.setPassword("1314520");
		user.setUsername("青春期的猪头不会梦到兔女郎学姐");
		session.saveOrUpdate(user);
		tx.commit();
		}catch(Exception e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			session.close();
//			sessionFactory.close();
		}
	}
	
	@Test
	public void addTest2() {
//		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
//		sessionFactory = HibernateUtiles.getSessionFactory();
		
		session = HibernateUtiles.getSessionObject();
		tx = session.beginTransaction();
		
		User user = new User();
		user.setAdress("异次元");
		user.setPassword("1314520");
		user.setUsername("青春期的猪头不会梦到兔女郎学姐");
		session.saveOrUpdate(user);
		tx.commit();
		}catch(Exception e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			session.close();
//			sessionFactory.close();
		}
	}
	
	

	/*@Test
	public void add_test() {

		//      1调用工具类取得sessionFactry
		SessionFactory sessionFactory = HibernateUtiles.getSessionFactory();
		//		2获取session
		Session session = sessionFactory.openSession();
		//		3开启事务
		Transaction tx = session.beginTransaction();

		//		4根据id查询
//		User user = session.get(User.class, 1);
//		System.out.println(user);

//		4根据id修改
//		修改uid=2记录username值
//		4.1根据id进行查询
		User user = session.get(User.class, 2);
//		4.2向返回的user对象里面设置修改之后的值
		user.setUsername("东方不败");
//		4.3调用session的方法update进行修改
//		执行过程中：到user对象里找到uid，在根据uid进行修改
		session.update(user);
		System.out.println(user);
		 

	  User user = new User();  //此状态为托管态，更新操作
		user.setUid(1);
		user.setAdress("津巴布韦");
		user.setPassword("1314");
		user.setUsername("lucy");
		session.saveOrUpdate(user);

		User user = new User();  //此状态为瞬时态，保存操作
		user.setAdress("津巴布韦");
		user.setPassword("1314");
		user.setUsername("lucy");
		session.saveOrUpdate(user);

		User user = session.get(User.class, 2);  //此状态为持久态，更新操作
		user.setAdress("江湖危险");
		session.saveOrUpdate(user);


		//		5提交事务
		tx.commit();
		//		6关闭资源
		session.close();
		sessionFactory.close();
	}*/

	/*@Test
	public void testDelete() {

//      1调用工具类取得sessionFactry
		SessionFactory sessionFactory = HibernateUtiles.getSessionFactory();
//		2获取session
		Session session = sessionFactory.openSession();
//		3开启事务
		Transaction tx = session.beginTransaction();


//		4根据id删除
//		User user = session.get(User.class, 3);
//		session.delete(user);

		User user1 = new User();
		user1.setUid(4);
		session.delete(user1);


//		5提交事务
		tx.commit();
//		6关闭资源
		session.close();
		sessionFactory.close();
	}*/

}
