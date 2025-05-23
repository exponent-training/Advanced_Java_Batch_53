package com.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {

	public static void main(String[] args) {
		
		Configuration cfg =  new Configuration().configure("hibernate.cfg.xml");
		
		SessionFactory sf = cfg.buildSessionFactory();
		
		Session session = sf.openSession();
		
		Student student = new Student();
		student.setId(21);student.setName("ABC");student.setAddress("Pune");
		
		session.save(student);
		
		Transaction  tx = session.beginTransaction();
	    tx.commit();
	}
	
}
