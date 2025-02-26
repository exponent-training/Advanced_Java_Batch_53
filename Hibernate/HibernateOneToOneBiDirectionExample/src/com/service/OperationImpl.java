package com.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.model.Passport;
import com.model.Person;
import com.util.HibernateUtil;

public class OperationImpl implements OperationI{

	SessionFactory sf = HibernateUtil.getSessionFactory();
	
	@Override
	public void savePersonDataWithPassport() {
		Person person = new Person();
		person.setName("Abcd");person.setAddress("Pune");
		person.setMobNo("9876543213");
		
		Passport passport = new Passport();
		passport.setPassNo("IN234276FRD");
		passport.setPassportIssuedName("India");
		
		person.setPassport(passport);
		passport.setPerson(person);
		
		Session session =sf.openSession();
		
		session.save(person);
		session.save(passport);
		
		session.beginTransaction().commit();
		System.out.println("Data Inserted");
		
	}

	@Override
	public void savePassportwithPersonData() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getPassportDataByPersonId() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		Person person = session.get(Person.class, 1);
		System.out.println(person);
	}

	@Override
	public void getPersonDataByPassportId() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		Passport passport = session.get(Passport.class, 1);
		System.out.println(passport);
		System.out.println(passport.getPerson());
	}

	@Override
	public void getPersonAllDataWithPassportData() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		Query<Person> query = session.createQuery("from Person",Person.class);
		List<Person> plist = query.getResultList();
		System.out.println(plist);
		
		for(Person person : plist) {
			System.out.println("----------------------------------------------------------");
			System.out.println( "Person Id : " + person.getId());
			System.out.println( person.getName());
			System.out.println( person.getAddress());
			System.out.println( person.getMobNo());
			System.out.println( person.getPassport().getId());
			System.out.println( person.getPassport().getPassNo());
			System.out.println( person.getPassport().getPassportIssuedName());
			System.out.println("------------------------------------------------------------");
		}
	}

	@Override
	public void getPassportAllDataWithPersonData() {
		// TODO Auto-generated method stub
		
	}

}
