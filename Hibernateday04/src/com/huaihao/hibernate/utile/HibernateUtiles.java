package com.huaihao.hibernate.utile;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtiles {
	
	static Configuration cfg;
	static SessionFactory sessionFactory;
//	静态代码块实现
	static {
		//加载核心配置文件
		cfg = new Configuration();
		cfg.configure();
		if(sessionFactory == null || sessionFactory.isClosed()) {  //工厂类是重量级的非常耗费资源，创建对象时要先判断一下是否被创建过
			sessionFactory = cfg.buildSessionFactory();
		}
	}
//	提供与本地线程绑定的session方法
	public static Session getSessionObject() {
		return sessionFactory.getCurrentSession();
	}
	
//	提供方法返回sessionFactory对象
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
