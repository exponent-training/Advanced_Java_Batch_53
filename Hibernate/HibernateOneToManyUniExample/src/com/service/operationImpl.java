package com.service;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.model.AddToCart;
import com.model.User;
import com.util.HibernateUtil;

public class operationImpl implements OperationI {

	SessionFactory sf = HibernateUtil.getSessionFactory();


	@Override
	public void addingUserWithAddToCartData() {
		// TODO Auto-generated method stub
		User user = new User();
		user.setName("Admin");user.setUname("admin");

		Scanner sc = new Scanner(System.in);

		System.out.println("how many product add to cart");
		int no = sc.nextInt();

		for (int i = 0; i < no; i++) {

			AddToCart addToCart = new AddToCart();
			addToCart.setProductName("Samsung s23");
			addToCart.setType("Electronics");
			addToCart.setPrice(125000);
			addToCart.setModelNumber("SM12345");

			user.getAddToCart().add(addToCart);
		}

		Session session = sf.openSession();
		session.save(user);
		session.beginTransaction().commit();
		System.out.println("Done");
	}

	@Override
	public void getUserDataWithAddToCartUsingUserId() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Your id : ");
		int id = sc.nextInt();

		User user = session.get(User.class, id);
		//		if(!Objects.isNull(user)) {
		//			System.out.println(user.getName());
		//		}else {
		//			System.out.println("User Does not exists.");
		//		}
		if(user != null) {
			System.out.println(user.getName());
		} else {
			System.out.println("User Does not exists.");
		}
	}

	@Override
	public void getAllUserDataWithAddToCart() {
		// TODO Auto-generated method stub
        Session session = sf.openSession();
        Query<User> query = session.createQuery("from User", User.class);
        List<User> ulist = query.getResultList();
        System.out.println(ulist);
	}

	@Override
	public void updateUserDataUsingUserID() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Your id : ");
		int id = sc.nextInt();

		User user = session.get(User.class, id);
		//		if(!Objects.isNull(user)) {
		//			System.out.println(user.getName());
		//		}else {
		//			System.out.println("User Does not exists.");
		//		}
		if(user != null) {
			System.out.println(user.getName());
			user.setName("Ajas");
			user.setUname("ajas.shaikh");
			
			session.update(user);
			
			session.beginTransaction().commit();
		} else {
			System.out.println("User Does not exists.");
		}
	}

	@Override
	public void updateAddToCartUsingUserId() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Your id : ");
		int id = sc.nextInt();

		User user = session.get(User.class, id);
		if(user != null) {
			System.out.println(user.getName());
		   
			List<AddToCart> list = user.getAddToCart();
		    
			if(list.size() > 0) {
				
				for(AddToCart ad : list) {
					if(ad.getModelNumber() != null) {
						System.out.println("Please provide Model number : ");
						String modelnumber = sc.next();
						if(modelnumber.equals(ad.getModelNumber())) {
							ad.setProductName("Apple 16pro");
							ad.setPrice(120000);
							ad.setType("Electrionics");
							break;
						}
					}
				}
//				for(int i=0; i < list.size();i++) {
//					AddToCart ad = list.get(i);
//				}

			} else {
				System.out.println("Add to cart is empty.");
			}
		      session.update(user);
		      session.beginTransaction().commit();
		} else {
			System.out.println("User Does not exists.");
		}
	}

	@Override
	public void deleteAddToCartUsingUserId() {
		// TODO Auto-generated method stub

	}



}
