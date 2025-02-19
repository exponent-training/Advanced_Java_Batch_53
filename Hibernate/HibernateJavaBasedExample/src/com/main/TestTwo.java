package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.model.Driver;
import com.utility.HibernateUtil;

public class TestTwo {
	
	public static void main(String[] args) {
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		
		Session session = sf.openSession();
		
		Driver driver = session.get(Driver.class, 1);
		
		session.delete(driver);
		
		session.beginTransaction().commit();
	}

}
