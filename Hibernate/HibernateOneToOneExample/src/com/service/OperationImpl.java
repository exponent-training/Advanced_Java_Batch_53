package com.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.model.Login;
import com.model.Person;
import com.util.HibernateUtil;

public class OperationImpl implements OperationI {

	SessionFactory sf = HibernateUtil.getSessionFactory();
	
	@Override
	public void insertLoginWithPersonData() {
		Login login = new Login();
		Person person = new Person();
		
		login.setUsername("admin");
		login.setPassword("admin");
		
		person.setName("Anonymous");
		person.setLogintype("Gmail");
		
		login.setPerson(person);
		
		Session session = sf.openSession();
		session.save(login);
		session.beginTransaction().commit();
	}

	@Override
	public void getLoginWithPersonUsingLoginId() {
        Session session = sf.openSession();
		Login login = session.get(Login.class, 1);
		System.out.println(login);
		
		Login login2 = session.get(Login.class, 2);
		System.out.println(login2);
		
		//session.evict(login);
		session.clear();
		
		Login login1 = session.get(Login.class, 1);
		System.out.println(login1);
		
		Login login3 = session.get(Login.class, 2);
		System.out.println(login3);
	}

}
