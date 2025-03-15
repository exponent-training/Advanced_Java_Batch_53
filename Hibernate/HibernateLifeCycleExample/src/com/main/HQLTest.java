package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.model.Employee;
import com.util.HibernateUtil;

public class HQLTest {
	
	public static void main(String[] args) {
		
		SessionFactory sf = HibernateUtil.getConnection();
		
		Session session = sf.openSession();
		
		// 1. Select * from Employee Where id = ? 
		Query<Employee> query = session.createQuery("from Employee where id = :id1",Employee.class);
		query.setParameter("id1", 1);
		Employee employee = query.getSingleResult();
		System.out.println(employee);
		
		//update employee set name=? where id = ?
		Query<?> query1 = session.createQuery("update Employee set name=:n where id =:id1");
		query1.setParameter("n", "Anon");
		query1.setParameter("id1", 1);
		int i = query1.executeUpdate();
		System.out.println(i + " Row Updated");
	}

}
