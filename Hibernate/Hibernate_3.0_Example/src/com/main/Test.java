package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.model.Car;

public class Test {
	
	public static void main(String[] args) {
		
		
		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
		
		SessionFactory sf =cfg.buildSessionFactory();
		
		Session session = sf.openSession();
		
		Car car = new Car();
		car.setId(14);car.setName("Honda City");car.setType("Dizel");car.setPrice(20000000);
		
		session.save(car);
		
		Transaction tx = session.beginTransaction();
		tx.commit();
	}

}
