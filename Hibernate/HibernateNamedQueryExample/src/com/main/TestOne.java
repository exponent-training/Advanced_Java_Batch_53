package com.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.entity.CarData;
import com.util.HibernateIUtil;

public class TestOne {

	public static void main(String[] args) {


		SessionFactory sf = HibernateIUtil.getSessionFactory();

		Session session = sf.openSession();

		Query<CarData> query = session.createNamedQuery("allData",CarData.class);
		List<CarData> list = query.getResultList();
		System.out.println(list);

		
		Query<CarData> query1 = session.createNamedQuery("byId",CarData.class);
		query1.setParameter("id", 1);
		CarData carData = query1.getSingleResult();
		System.out.println(carData);
		
		session.beginTransaction();
		
		Query<?> query2 = session.createNamedQuery("updateNamebyId");
		query2.setParameter("name", "Honda City");
		query2.setParameter("id", 1);
		
		query2.executeUpdate();
		
		Query<CarData> query3 = session.getNamedNativeQuery("all");
		List<CarData> list3 = query3.getResultList();
		System.out.println(list3);
		
		
		Query<?> query5 = session.createNamedQuery("checkUpdate");
		query5.setParameter(1, 1800000);
		query5.setParameter(2, 1);
		
		query5.executeUpdate();
	}

}
