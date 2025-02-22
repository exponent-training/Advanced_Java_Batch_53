package com.serviceimpl;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.model.PanCard;
import com.service.PanCardService;
import com.util.HibernateUtil;

public class PanCardServiceImpl implements PanCardService{
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();


	@Override
	public void registration() {
		
		Session session = sessionFactory.openSession();
		
		PanCard p = new PanCard();
		
		p.setPanNumber("lopd8925f");
		p.setPanName("Priya");
		p.setPanAddress("Pune");
		
		Serializable save = session.save(p);
		System.out.println(save);
		
		session.persist(p);
		
		session.beginTransaction().commit();
	}


	@Override
	public void registerSaveOrupdate() {
Session session = sessionFactory.openSession();
		
		PanCard p = new PanCard();
		
//		p.setPanNumber("jsid7541h");
//		p.setPanName("mangu");
//		p.setPanAddress("mumbai");
		
		PanCard panCard = session.get(PanCard.class, 2);
		panCard.setPanName("sumi");
		session.saveOrUpdate(panCard);
		
		session.beginTransaction().commit();
	}

}
