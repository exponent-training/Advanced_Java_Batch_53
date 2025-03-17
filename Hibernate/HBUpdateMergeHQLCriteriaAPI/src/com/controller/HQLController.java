package com.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.entity.Person;
import com.entity.User;
import com.util.HibernateUtil;

public class HQLController {
	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSessionFactory();

		// updatePersonDetails(sf);

		// deletePersonById(sf);

		// fetchByMailId(sf);

		// fetchPersonDetails(sf);

		//fetchPersonDetailsById(sf);
		
		//fetchnthOrderSalary(sf);
		
		fetchPersonDetailsByInOperator(sf);
		
		
		//countNoOfPersons(sf);

		/*
		 * Session session = sf.openSession();
		 * 
		 * Person p1 = new Person(); p1.setName("aartai");
		 * p1.setEmailid("aarati@gmail.com"); p1.setSalary(45000);
		 * 
		 * Person p2 = new Person(); p2.setName("gunjan");
		 * p2.setEmailid("gunjan@yahoo.com"); p2.setSalary(44000);
		 * 
		 * Person p3 = new Person(); p3.setName("jay"); p3.setEmailid("jay@gmail.com");
		 * p3.setSalary(30000);
		 * 
		 * Person p4 = new Person(); p4.setName("ram"); p4.setEmailid("ram@gmail.com");
		 * p4.setSalary(67000);
		 * 
		 * Person p5 = new Person(); p5.setName("manish");
		 * p5.setEmailid("manish@yahoo.com"); p5.setSalary(89000);
		 * 
		 * List<Person> personList = new ArrayList<Person>();
		 * 
		 * Collections.addAll(personList, p1,p2,p3,p4,p5);
		 * 
		 * for (Person person : personList) { session.save(person); }
		 */
		System.out.println("success!!");

	}

	private static void fetchPersonDetailsByInOperator(SessionFactory sf) {
		Session session = sf.openSession();
		
		List<Integer> list = new ArrayList<Integer>();
		Collections.addAll(list, 1,4,7);
		Query<Person> query =session.createQuery("from Person where id in (:list1)");
		
		query.setParameterList("list1", list);
		
	
		
		List<Person> personlist = query.getResultList();
		
		System.out.println(personlist);
		
	}

	private static void countNoOfPersons(SessionFactory sf) {
		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		Query<Long> query = session.createQuery("select count(*) from Person");
		
		Long i = query.getSingleResult();
		
		System.out.println("count= "+i);
		
		tx.commit();
		
	}

	private static void fetchnthOrderSalary(SessionFactory sf) {
		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		Query<Double> query = session.createQuery("select salary from Person order by salary asc");
		
		List<Double> listOfSalary = query.getResultList();
		
		System.out.println("List of salary ASC------------------");
		
		for (Double salary : listOfSalary) {
			System.out.println(salary);
		}
		
		
		
		query.setFirstResult(2);
		query.setMaxResults(1);
		
		System.out.println("third lowest salary= "+query.getSingleResult());
	}

	private static void fetchByMailId(SessionFactory sf) {
		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		Query query = session.createQuery("select emailid from Person where emailid like '%yahoo%'");

		List<String> list = query.getResultList();

		System.out.println(list);

	}

	private static void deletePersonById(SessionFactory sf) {

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		Query query = session.createQuery("delete from Person where id=:id1");

		query.setParameter("id1", 2);

		query.executeUpdate();

		tx.commit();

	}

	public static void updatePersonDetails(SessionFactory sf) {

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		Query<String> query = session.createQuery("update Person set emailid=:emailupdated where id=:id1");

		query.setParameter("emailupdated", "aarati123@gmail.com");
		query.setParameter("id1", 1);

		query.executeUpdate();

		tx.commit();

	}


	public static void fetchPersonDetails(SessionFactory sf) {

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		Query<Object[]> query = session.createQuery("select name, salary, emailid from Person");

		List<Object[]> list = query.getResultList(); // [obj1[], obj2[], obj3[]]

		System.out.println(list);

		for (Object[] objectObj : list) {
			System.out.println(Arrays.toString(objectObj));
		}

		tx.commit();

	}

	public static void fetchPersonDetailsById(SessionFactory sf) {

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		Query<Object[]> query = session.createQuery("select name, salary, emailid from Person where id=:id1");

		query.setParameter("id1", 4);

		List<Object[]> list = query.getResultList(); // [obj1[], obj2[], obj3[]]

		System.out.println(list);

		for (Object[] objectObj : list) {
			System.out.println(Arrays.toString(objectObj));
		}

		tx.commit();

	}
	
	public static void fetchSalaryFromPersonDetails(SessionFactory sf) {

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		Query<Double> query = session.createQuery("select salary from Person order by salary");

		System.out.println("list = ");
	
		List<Double> list = query.getResultList();
		
		for (Double salary : list) {
			System.out.println(salary);
		}
		
		query.setFirstResult(1);
		query.setMaxResults(1);
		
		System.out.println("second lowest salary="+query.getSingleResult());
		
		tx.commit();

	}


}
