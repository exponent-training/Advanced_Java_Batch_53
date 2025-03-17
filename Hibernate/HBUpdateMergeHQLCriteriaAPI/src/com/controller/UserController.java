package com.controller;

import java.util.List;

import org.hibernate.Cache;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.entity.User;
import com.util.HibernateUtil;

public class UserController {

	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		
		User user1 = session.get(User.class, 2);
		
		session.close();
		
		user1.setAddress("ravet");
		
		/*
		 * Session session1 = sf.openSession();
		 * 
		 * Transaction tx = session1.beginTransaction();
		 * 
		 * User user2 = session1.get(User.class, 2);
		 * 
		 * session1.update(user1);
		 * 
		 * tx.commit();
		 */
		
		Session session1 = sf.openSession();
		
		 Transaction tx = session1.beginTransaction();
		
		 User user2 = session1.get(User.class, 2);
		 
		 session1.merge(user1);
		
		tx.commit();
		
		System.out.println("success..");
		
		
		

	}
	
	
}