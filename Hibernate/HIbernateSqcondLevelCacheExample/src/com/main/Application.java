package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.entity.Employee;
import com.util.HIbernateUtil;

public class Application {
	
	public static void main(String[] args) {
		
		SessionFactory  sf = HIbernateUtil.getSessionFactory();
		
		Session session = sf.openSession();
		
//		Employee employee = new Employee();
//		
//		employee.setName("Abcd");employee.setAddress("Pune");
//		employee.setEdesignation("Developer");employee.setSalary(32000);
//		
//		session.save(employee);
//		session.beginTransaction().commit();
		
		Employee employee = session.get(Employee.class, 1);
		System.out.println(employee);
		
		System.out.println("---------------------------------------------");
		//session.evict(employee);
		
		Session session1 = sf.openSession();
		
		Employee employee1 = session1.get(Employee.class, 1);
		System.out.println(employee1);
		
	}

}
