package com.main;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.model.OrderData;
import com.util.HibernateUtil;

public class Test {
	
	public static void main(String[] args) {
		
		
		 SessionFactory sf = new HibernateUtil().getSessionFactory();
		 
		 Session session = sf.openSession();
		 
		 OrderData orderData = new OrderData();
		 
		 orderData.setOrderid("ORD2356754");
		 orderData.setOrderName("Samsung S23");
		 
		 SimpleDateFormat format = new SimpleDateFormat("dd-mmm-yyyy");
		 Date date = new Date(System.currentTimeMillis());
		
		 System.out.println(date);
		 
		 String strDate = format.format(date);
		 
		 orderData.setOrderdate(strDate);
		 
		 orderData.setDelivered(false);
		 
		 session.save(orderData);
		 
		 session.beginTransaction().commit();
		 
		 System.out.println("Done");
		 
		  
	}

}
