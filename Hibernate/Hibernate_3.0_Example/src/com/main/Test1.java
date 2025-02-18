package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.model.Car;

public class Test1 {
	
	public static void main(String[] args) {
		
		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		Session session = sf.openSession();
		
		Car car = session.get(Car.class, 14);
		System.out.println(car);
		
		Car car1 = session.load(Car.class, 14);
		System.out.println(car1);
	}

}
