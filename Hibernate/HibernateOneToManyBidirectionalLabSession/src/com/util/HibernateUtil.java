package com.util;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

import com.Entity.CompanyDetails;
import com.Entity.Employee;


public class HibernateUtil {
	
	private HibernateUtil() {
		// TODO Auto-generated constructor stub
	}
	
	private static SessionFactory sf = null;
	
	private static StandardServiceRegistry registry = null;
	
	public static SessionFactory getSessionFactory() {
		if (sf == null) {
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
			map.put(Environment.URL, "jdbc:mysql://localhost:3307/test53");
			map.put(Environment.USER, "root");
			map.put(Environment.PASS, "root");
			
			map.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
			map.put(Environment.SHOW_SQL, true);
			map.put(Environment.HBM2DDL_AUTO, "update");
			//map.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
			
			registry = new StandardServiceRegistryBuilder().applySettings(map).build();
			
			MetadataSources mds = new MetadataSources(registry).addAnnotatedClass(Employee.class).addAnnotatedClass(CompanyDetails.class);
			
			Metadata md = mds.getMetadataBuilder().build();
			
			 sf = md.buildSessionFactory();
			}
		return sf;
	}


}
