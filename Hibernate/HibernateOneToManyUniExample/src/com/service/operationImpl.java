package com.service;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

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
		
	}

	@Override
	public void getAllUserDataWithAddToCart() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUserDataUsingUserID() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateAddToCartUsingUserId() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAddToCartUsingUserId() {
		// TODO Auto-generated method stub
		
	}
	
	

}
