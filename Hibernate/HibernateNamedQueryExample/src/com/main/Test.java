package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.entity.CarData;
import com.util.HibernateIUtil;

public class Test {
	
	public static void main(String[] args) {
		
		
		SessionFactory sf = HibernateIUtil.getSessionFactory();
		
		Session session = sf.openSession();
		
		
		CarData carData = new CarData();
		carData.setCname("Honda"); carData.setCmodel("City");
		carData.setCtype("Disel");carData.setCengnumber("ZJI876OKj26154");
		carData.setMyear("Dec-2021");carData.setPrice(2000000);
		carData.setCng("No");
		
		CarData carData1 = new CarData();
		carData1.setCname("BMW"); carData1.setCmodel("M5");
		carData1.setCtype("Disel");carData1.setCengnumber("ZJ325QW6OKj26154");
		carData1.setMyear("Feb-2022");carData1.setPrice(20000000);
		carData1.setCng("No");
		
		CarData carData2 = new CarData();
		carData2.setCname("Toyota Innova"); carData2.setCmodel("Hycross");
		carData2.setCtype("Disel");carData2.setCengnumber("YVHF5657OP26154");
		carData2.setMyear("Jun-2023");carData2.setPrice(4000000);
		carData2.setCng("No");
		
		session.save(carData);session.save(carData1);session.save(carData2);
		
		session.beginTransaction().commit();
	}

}
