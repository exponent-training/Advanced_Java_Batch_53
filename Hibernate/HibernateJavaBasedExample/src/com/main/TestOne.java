package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.model.Driver;
import com.utility.HibernateUtil;

public class TestOne {
	
	public static void main(String[] args) {
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		
		Session session = sf.openSession();
		
		Driver driver = session.get(Driver.class, 1);
		driver.setBatchNumber("BA321");
		
		session.update(driver);
		
		session.beginTransaction().commit();
	}

}
