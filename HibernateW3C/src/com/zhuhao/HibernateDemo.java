package com.zhuhao;


import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.Test;

import com.zhuhao.utile.HibernateUtiles;

public class HibernateDemo {
	
	@Test
	public void add() {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtiles.getSessionObject();
			tx = session.beginTransaction();
			
			Employee employee = new Employee();
			employee.setName("xiaofangfang");
			employee.setAdress("changzhou");
			employee.setAge(18);
			employee.setSalary(5000);
			employee.setSex("girll");
			
			session.saveOrUpdate(employee);
			
			tx.commit();
		} catch (Exception e) {
			
			tx.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
	}
	
	@Test
	public void query01() {  //查询操作方式一：query
		Session session = null;
		Transaction tx = null;
		try {
		    session = HibernateUtiles.getSessionObject();
		    tx = session.beginTransaction();
		    
		    Query<Employee> query = session.createQuery("from Employee");
		    List<Employee> list = query.list();
		    
		    for (Employee employee : list) {
				System.out.println(employee);
			}
		    
		    tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void query02() {  //查询操作方式二：query
		Session session = null;
		Transaction tx = null;
		try {
		    session = HibernateUtiles.getSessionObject();
		    tx = session.beginTransaction();
		    String sql = "delete from employee where id=2";
//		    String sql = "select*from Employee";
//		    SQLQuery sqlquery = session.createSQLQuery(sql).addEntity(Employee.class);
		    int sum = session.createSQLQuery(sql).executeUpdate();
//		    List<Employee> list =sqlquery.list();
//		    
//		    for (Employee employee : list) {
//				System.out.println(employee);
//			}
//		    
		    tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		
	}

}
