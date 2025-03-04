package com.service;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.model.DigitalAccount;
import com.model.Person;
import com.util.Hibernateutil;

public class OperartionImpl implements OperationI{
	
	SessionFactory sf = Hibernateutil.getSessionFactory();

	@Override
	public void addDigitalAccountDataWithPerson() {
		
		Session session = sf.openSession();
		
		Scanner sc = new Scanner(System.in);
		
		Person person = new Person();
		person.setPname("Anonymous");person.setPuserid("Admin");
		person.setPuserpass("admin");
		
	    System.out.println("How many Digital Account To be Creating :");
		int n = sc.nextInt();
		
		for(int i = 0 ; i < n ; i++) {
			DigitalAccount digitalAccount = new DigitalAccount();
			System.out.println("Enter Your Digital Account Name:");
			String acname = sc.next();
			digitalAccount.setDaccountname(acname);
			System.out.println("Enter Your Digital Account Type:");
			String acType = sc.next();
			digitalAccount.setDaccounttype(acType);
			
			digitalAccount.setPerson(person);
			
			session.save(digitalAccount);
			session.beginTransaction().commit();
			System.out.println("Data Stored.");
		}
		
	}

	@Override
	public void getDigitalAccountDataWithPersonDataUsingDigitalId() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Digital Account Id :");
		int id =sc.nextInt();
		DigitalAccount digitalAccount = session.get(DigitalAccount.class, id);
		System.out.println(digitalAccount);
	}

	@Override
	public void getAllDigitalDataWithPersonData() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		Query<DigitalAccount> query = session.createQuery("from DigitalAccount",DigitalAccount.class);
		List<DigitalAccount> list = query.getResultList();
		System.out.println(list);
	}

	@Override
	public void updatePersonDataUsingDigitalAccountDataId() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateDigitalDatausingDigitalAccountDataId() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteDigitalAccountData() {
		// TODO Auto-generated method stub
		
	}

}
