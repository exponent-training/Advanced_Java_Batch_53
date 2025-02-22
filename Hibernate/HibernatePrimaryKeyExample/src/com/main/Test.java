package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.model.Car;
import com.model.CarDriver;
import com.model.Product;
import com.util.HibernateUtil;

public class Test {
	
	public static void main(String[] args) {
		
		SessionFactory sf = HibernateUtil.getConnection();
		
		Session session = sf.openSession();
		
		Car car = new Car();
		//car.setId(1);
		car.setCarName("Honda City");car.setCarType("Diesel");
		
		CarDriver carDriver = new CarDriver();
		//carDriver.setId(3);
		carDriver.setCarDriverName("Abcd");
		carDriver.setDriverContactNo("8765432189");
		
		
		
		//session.save(carDriver);
		//session.save(car);
		
		Product product = new Product();
		//product.setId(98);
		product.setPname("Samsung S21");
		product.setPtype("Electronic");
		product.setPrice("1010000");
		product.setStatus(true);
		
		session.saveOrUpdate(product);
		
//		int i = (int) session.save(product);
//		System.out.println(i);
		
		
		//session.persist(product);
		
		session.beginTransaction().commit();
		
		System.out.println("Done");
		
		
	}

}
