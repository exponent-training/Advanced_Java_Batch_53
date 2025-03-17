package com.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.entity.CarData;
import com.util.HibernateIUtil;

public class TestNativeQuery {
	
	public static void main(String[] args) {
		
		SessionFactory sf = HibernateIUtil.getSessionFactory();

		Session session = sf.openSession();
		
		Query<CarData> query = session.getNamedNativeQuery("all");
		List<CarData> list = query.getResultList();
		System.out.println(list);

	}

}
