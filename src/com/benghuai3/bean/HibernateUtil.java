package com.benghuai3.bean;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HibernateUtil {
	private static Configuration config;
	private static SessionFactory sessionfactory;
	static {
		config = new Configuration().configure();
		sessionfactory = config.buildSessionFactory();
	}
	public static Session openSession() {
		return sessionfactory.openSession();
	}
}
