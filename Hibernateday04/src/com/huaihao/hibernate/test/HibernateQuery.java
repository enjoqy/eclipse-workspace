package com.huaihao.hibernate.test;


import java.util.Arrays;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.query.Query;
import org.junit.Test;

import com.huaihao.hibernate.utile.HibernateUtiles;

public class HibernateQuery {
	
	@Test
	public void qbcSelectAll() {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtiles.getSessionObject();
			tx = session.beginTransaction();
			String sql = "select*from t_user limit ?,?";
			List<User> list = session.createCriteria(User.class).addOrder(Order.desc("adress")).list();
//			List<User> list = sqlquery.list();
			for (User user : list) { 	
				System.out.println(user);
			}
			
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			
		}finally {
			session.close();
		}
	}
	
	
}
