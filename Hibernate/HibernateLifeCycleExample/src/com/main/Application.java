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
         
         
         //select name,empid from employeeinfo where id =?  using by Named Query Without Annotation
         Query<Object[]> query2 = session.createQuery("select name, empCode from EmployeeInfo where id=:i");
         query2.setParameter("i", 1);
         List<Object[]> list = query2.getResultList();
         System.out.println(list);
         for(Object[] ob : list) {
        	 System.out.println("EMP NAME :  " + ob[0]);
        	 System.out.println("EMP CODE :  " + ob[1]);
         }
	     
         
         Query<Object[]> query3 = session.createQuery("select name, empCode from EmployeeInfo ");
         //query2.setParameter("i", 1);
         List<Object[]> list1 = query3.getResultList();
         System.out.println(list1);
         for(Object[] ob : list1) {
        	 System.out.println("EMP NAME :  " + ob[0]);
        	 System.out.println("EMP CODE :  " + ob[1]);
         }
         
         //Parameter Query
         Query<Object[]> query4 = session.createQuery("select e.name, e.empCode from EmployeeInfo AS e where id= ?1");
         query4.setInteger(1, 1);
         List<Object[]> list3 = query4.getResultList();
         System.out.println(list3);
         for(Object[] ob : list3) {
        	 System.out.println("EMP NAME :  " + ob[0]);
        	 System.out.println("EMP CODE :  " + ob[1]);
         }
         
         
         //Aggregation Function  -- Sum , Count, max, min, Avg, 
         Query<Long> query5 = session.createQuery("select count(*) from EmployeeInfo AS e");
         Long countObject = query5.getSingleResult();
         System.out.println("Count  : " + countObject);
         
        
		@SuppressWarnings("unchecked")
		Query<Double> query6 = session.createQuery("select sum(salary) from EmployeeInfo AS e");
        Double sumObject = query6.getSingleResult();
        System.out.println("Sum  : " + sumObject);
        
        
        @SuppressWarnings("unchecked")
		Query<Double> query7 = session.createQuery("select max(salary) from EmployeeInfo AS e");
        Double maxObject = query7.getSingleResult();
        System.out.println("Max  : " + maxObject);
        
        
        @SuppressWarnings("unchecked")
		Query<Double> query8 = session.createQuery("select min(salary) from EmployeeInfo AS e");
        Double minObject = query8.getSingleResult();
        System.out.println("Min  : " + minObject);
       
        @SuppressWarnings("unchecked")
		Query<Double> query10 = session.createQuery("select avg(salary) from EmployeeInfo AS e");
        Double avgObject = query10.getSingleResult();
        System.out.println("AVG  : " + avgObject);
        
        // Find 2nd Min and Max Salary   or n th no.  min and max Salary
//        @SuppressWarnings("unchecked")
//		  Query<Double> query9 = session.createQuery("select min(salary) from EmployeeInfo AS e");
//        Double secondObject = query9.getSingleResult();
//        System.out.println("Min  : " + secondObject);
        
        // Pagination Data calling
        Query<EmployeeInfo> query11 = session.createQuery("from EmployeeInfo",EmployeeInfo.class);
        query11.setFirstResult(2);
        query11.setMaxResults(1);
        List<EmployeeInfo> elist1 = query11.getResultList();
        System.out.println(elist1);
        
        //Expression <,> =<
        Query<Object[]> query12 = session.createQuery("select e.name, e.empCode from EmployeeInfo AS e where salary > 27000 order by e.salary asc ");
        List<Object[]> list11 = query12.getResultList();
        System.out.println(list11);
        for(Object[] ob : list11) {
       	 System.out.println("EMP NAME :  " + ob[0]);
       	 System.out.println("EMP CODE :  " + ob[1]);
        }
	}

}
