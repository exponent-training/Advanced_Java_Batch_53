package com.controller;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.entity.Person;
import com.util.HibernateUtil;

public class AdminController {

	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSessionFactory();

		// getDetailsOfPersons(sf);

		// fetchSalaryBetweenRanges(sf);

		// fetchPersoDetailsUsingInOperator(sf);

//		fetchPersoDetailsUsingInOperatorForMailid(sf);

		// fetchPersonDetailsByLikeOperator(sf);

		// fetchPersonDetailsByAccordingToId(sf);

		findingMaxSalary(sf);

	}

	private static void findingMaxSalary(SessionFactory sf) {

		Session session = sf.openSession();

		Criteria cr1 = session.createCriteria(Person.class);
		
		Criteria maxsal = cr1.setProjection(Projections.max("salary"));
		
		System.out.println("max salary= "+maxsal.uniqueResult());
		
		Criteria cr2 = session.createCriteria(Person.class);
		
		Criteria avgSal = cr2.setProjection(Projections.avg("salary"));
		
		System.out.println("avg salary= "+avgSal.uniqueResult());
	}

	private static void fetchPersonDetailsByAccordingToId(SessionFactory sf) {
		Session session = sf.openSession();

		Criteria cr1 = session.createCriteria(Person.class);
		System.out.println("---------------ascending order-----------");

		List<Person> list = cr1.addOrder(Order.asc("id")).list();

		for (Person person : list) {
			System.out.println(person);
		}

		System.out.println("---------------descending order-----------");

		Criteria cr2 = session.createCriteria(Person.class);
		List<Person> list1 = cr2.addOrder(Order.desc("id")).list();

		for (Person person : list1) {
			System.out.println(person);
		}

	}

	private static void fetchPersonDetailsByLikeOperator(SessionFactory sf) {
		Session session = sf.openSession();

		Criteria cr1 = session.createCriteria(Person.class);

		cr1.add(Restrictions.like("emailid", "%gmail%"));

		List<Person> list = cr1.list();

		for (Person person : list) {
			System.out.println(person);
		}

	}

	private static void fetchPersoDetailsUsingInOperatorForMailid(SessionFactory sf) {
		Session session = sf.openSession();

		Criteria cr1 = session.createCriteria(Person.class);

		/*
		 * String[] mailids =
		 * {"aarati123@gmail.com","ganesh@rediffmail.com","manish@yahoo.com"};
		 * cr1.add(Restrictions.in("emailid", mailids));
		 */

		cr1.add(Restrictions.in("emailid", "ganesh@rediffmail.com", "manish@yahoo.com"));

		List<Person> list = cr1.list();

		for (Person person : list) {
			System.out.println(person);
		}

	}

	private static void fetchPersoDetailsUsingInOperator(SessionFactory sf) {
		Session session = sf.openSession();

		Criteria cr1 = session.createCriteria(Person.class);

		Integer[] array = { 1, 4 };
		cr1.add(Restrictions.in("id", array));

		List<Person> list = cr1.list();

		for (Person person : list) {
			System.out.println(person);
		}

	}

	private static void fetchSalaryBetweenRanges(SessionFactory sf) {

		Session session = sf.openSession();

		Criteria cr1 = session.createCriteria(Person.class);

		cr1.add(Restrictions.between("salary", 40000.00, 90000.00));

		List<Person> list = cr1.list();

		for (Person person : list) {
			System.out.println(person.getSalary());
		}

	}

	public static void getDetailsOfPersons(SessionFactory sf) {

		Session session = sf.openSession();

		Criteria criteria1 = session.createCriteria(Person.class);
		List<Person> personList = criteria1.list();

		System.out.println("Person details:");
		for (Person person : personList) {
			System.out.println(person);
		}
	}

}
