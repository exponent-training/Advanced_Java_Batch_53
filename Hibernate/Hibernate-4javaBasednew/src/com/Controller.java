package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.Student;

public class Controller {
	
	public static void main(String[] args) {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		Session openSession = sessionFactory.openSession();
		
		Student s = new Student();
		s.setRollno(2);
		s.setName("Suimi");
		s.setAddress("Indore");
		
		//openSession.saveOrUpdate(s);;
		
		Student student = openSession.get(Student.class, 2);
//		student.setName("Priya");
		openSession.delete(student);
		
		openSession.beginTransaction().commit();
	}

}
