package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.model.Employee;
import com.model.Student;
import com.util.HibernateUtil;

public class Test {
	
	public static void main(String[] args) {
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		
		Session session = sf.openSession();
		
		Employee employee = new Employee();
		employee.setName("Abcd");employee.setAddress("Pune");
		employee.setDesignation("Tester");employee.setSalary(35000);
		
		
		Employee employee1 = new Employee();
		employee1.setName("Xyz");employee1.setAddress("Pune");
		employee1.setDesignation("Manager");employee1.setSalary(65000);
		
		Employee employee2 = new Employee();
		employee2.setName("Lmon");employee2.setAddress("Pune");
		employee2.setDesignation("Devops");employee2.setSalary(55000);
		
		Employee employee3 = new Employee();
		employee3.setName("Pqrs");employee3.setAddress("Pune");
		employee3.setDesignation("Developer");employee3.setSalary(45000);
		
//		session.save(employee);session.save(employee1);
//		session.save(employee2);session.save(employee3);
		
		
		Student student = new Student();
		student.setName("Ajay");
		
		session.save(student);
		
		session.beginTransaction().commit();
	}

}
