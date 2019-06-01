package com.zhuhao.utile;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtiles {
	
	static Configuration cfg;
	static SessionFactory sessionfactory;

	static {
		cfg = new Configuration();
		cfg.configure();
		if(sessionfactory == null || sessionfactory.isClosed()) {
			sessionfactory = cfg.buildSessionFactory();
		}
	}

	public static Session getSessionObject(){
		return sessionfactory.getCurrentSession();
	}

}
