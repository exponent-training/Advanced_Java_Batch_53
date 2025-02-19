package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.model.Driver;
import com.utility.HibernateUtil;

public class Test {
	
	public static void main(String[] args) {
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		
		Driver driver = new Driver();
		
		driver.setId(1);driver.setName("Abcd");driver.setAddress("Akurdi");
		driver.setBatchNumber("B4321");driver.setContactNo(8267654321L);
		
		Session session = sf.openSession();
		
		session.save(driver);
		session.beginTransaction().commit();
	}

}
