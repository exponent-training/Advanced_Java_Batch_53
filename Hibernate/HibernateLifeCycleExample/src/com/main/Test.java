package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.model.Employee;
import com.util.HibernateUtil;

public class Test {
	
	public static void main(String[] args) {
		
		
		SessionFactory sf = HibernateUtil.getConnection();
		
		Employee employee = new Employee();
		
		employee.setName("Abcd");employee.setDesignation("Developer");
		employee.setEmpCode("EMP1234");employee.setSalary(45000);employee.setExperience(5);
		
		Session session = sf.openSession();
		
		session.save(employee);
		session.evict(employee);
		employee.setName("Anonymous");
		
		session.beginTransaction().commit();
		
		
		Session session2 = sf.openSession();
		Employee employee2 = session.get(Employee.class,1);
		System.out.println(employee2);
	}

}
