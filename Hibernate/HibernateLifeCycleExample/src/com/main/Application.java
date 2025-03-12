package com.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.model.EmployeeInfo;
import com.util.HibernateUtil;

public class Application {
	
	public static void main(String[] args) {
		
		SessionFactory sf = HibernateUtil.getConnection();
		
		Session session = sf.openSession();
		//Select * from employeeinfo;
         Query<EmployeeInfo> query = session.createQuery("from EmployeeInfo",EmployeeInfo.class);
         List<EmployeeInfo> elist = query.getResultList();
         System.out.println(elist);
         
         
        // update salary of Employeeinfo
//         session.beginTransaction();
//         Query<EmployeeInfo> query1 = session.createQuery("update EmployeeInfo set salary =:sal where id = :i",EmployeeInfo.class);
//         query1.setParameter("sal", 30000.0);
//         query1.setParameter("i", 4);
//         
//         int i = query1.executeUpdate();
//         System.out.println(i);
         
         
         //select name,empid from employeeinfo where id =?
         Query<Object[]> query2 = session.createQuery("select name, empCode from EmployeeInfo where id=:i");
         query2.setParameter("i", 1);
         List<Object[]> list = query2.getResultList();
         System.out.println(list);
         for(Object[] ob : list) {
        	 System.out.println("EMP NAME :  " + ob[0]);
        	 System.out.println("EMP CODE :  " + ob[1]);
         }
	     
	}

}
