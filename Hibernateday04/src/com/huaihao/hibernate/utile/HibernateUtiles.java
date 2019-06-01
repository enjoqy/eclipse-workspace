package com.huaihao.hibernate.utile;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtiles {
	
	static Configuration cfg;
	static SessionFactory sessionFactory;
//	��̬�����ʵ��
	static {
		//���غ��������ļ�
		cfg = new Configuration();
		cfg.configure();
		if(sessionFactory == null || sessionFactory.isClosed()) {  //���������������ķǳ��ķ���Դ����������ʱҪ���ж�һ���Ƿ񱻴�����
			sessionFactory = cfg.buildSessionFactory();
		}
	}
//	�ṩ�뱾���̰߳󶨵�session����
	public static Session getSessionObject() {
		return sessionFactory.getCurrentSession();
	}
	
//	�ṩ��������sessionFactory����
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
