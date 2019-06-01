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
		user.setAdress("���Ԫ");
		user.setPassword("1314520");
		user.setUsername("�ഺ�ڵ���ͷ�����ε���Ů��ѧ��");
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
		user.setAdress("���Ԫ");
		user.setPassword("1314520");
		user.setUsername("�ഺ�ڵ���ͷ�����ε���Ů��ѧ��");
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

		//      1���ù�����ȡ��sessionFactry
		SessionFactory sessionFactory = HibernateUtiles.getSessionFactory();
		//		2��ȡsession
		Session session = sessionFactory.openSession();
		//		3��������
		Transaction tx = session.beginTransaction();

		//		4����id��ѯ
//		User user = session.get(User.class, 1);
//		System.out.println(user);

//		4����id�޸�
//		�޸�uid=2��¼usernameֵ
//		4.1����id���в�ѯ
		User user = session.get(User.class, 2);
//		4.2�򷵻ص�user�������������޸�֮���ֵ
		user.setUsername("��������");
//		4.3����session�ķ���update�����޸�
//		ִ�й����У���user�������ҵ�uid���ڸ���uid�����޸�
		session.update(user);
		System.out.println(user);
		 

	  User user = new User();  //��״̬Ϊ�й�̬�����²���
		user.setUid(1);
		user.setAdress("��Ͳ�Τ");
		user.setPassword("1314");
		user.setUsername("lucy");
		session.saveOrUpdate(user);

		User user = new User();  //��״̬Ϊ˲ʱ̬���������
		user.setAdress("��Ͳ�Τ");
		user.setPassword("1314");
		user.setUsername("lucy");
		session.saveOrUpdate(user);

		User user = session.get(User.class, 2);  //��״̬Ϊ�־�̬�����²���
		user.setAdress("����Σ��");
		session.saveOrUpdate(user);


		//		5�ύ����
		tx.commit();
		//		6�ر���Դ
		session.close();
		sessionFactory.close();
	}*/

	/*@Test
	public void testDelete() {

//      1���ù�����ȡ��sessionFactry
		SessionFactory sessionFactory = HibernateUtiles.getSessionFactory();
//		2��ȡsession
		Session session = sessionFactory.openSession();
//		3��������
		Transaction tx = session.beginTransaction();


//		4����idɾ��
//		User user = session.get(User.class, 3);
//		session.delete(user);

		User user1 = new User();
		user1.setUid(4);
		session.delete(user1);


//		5�ύ����
		tx.commit();
//		6�ر���Դ
		session.close();
		sessionFactory.close();
	}*/

}
