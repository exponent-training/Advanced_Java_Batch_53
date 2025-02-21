package com.serviceImpl;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.model.Product;
import com.service.ProductService;
import com.util.HibernateUtil;

public class ProductServiceImpl implements ProductService {

	SessionFactory sf = HibernateUtil.getSessionFactory();

	@Override
	public void additem() {

		Session session = sf.openSession();

		Scanner sc = new Scanner(System.in);

		Product p = new Product();
		System.out.println("Enter your product name:-");
		p.setPname(sc.next());

		System.out.println("Enter Supplier name:-");
		p.setSupplierName(sc.next());

		System.out.println("Enter your product status:-");
		p.setStatus(sc.next().trim());

		System.out.println("Enter product price:-");
		p.setPrice(sc.nextInt());

		System.out.println("Enter stock details:-");

		p.setStockDetails(sc.nextInt());

		session.save(p);

		session.beginTransaction().commit();

	}

	@Override
	public void getProductById() {

		Session session = sf.openSession();

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter product id:-");
		Product p = session.get(Product.class, sc.nextInt());
		
		if(p != null) {
		
		System.out.println(p);
		System.out.println("ProductName:-" + p.getPname());
		
		}else {
			System.out.println("Product id invalid");
		}

	}

	@Override
	public void updateProductById() {
		Session session = sf.openSession();

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter product id:-");
		Product p = session.get(Product.class, sc.nextInt());
		
		p.setPname("5star");
		
		session.update(p);
		
		session.beginTransaction().commit();
	}

	@Override
	public void DeleteProductById() {
		// TODO Auto-generated method stub

	}

}
