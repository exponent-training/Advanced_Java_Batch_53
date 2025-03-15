package com.main;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Predicate;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.model.EmployeeInfo;
import com.util.HibernateUtil;

public class Application {


	public static void main(String[] args) {


		SessionFactory sf = HibernateUtil.getConnection();

		Session session = sf.openSession();

		
		@SuppressWarnings("deprecation")
		Criteria criteria = session.createCriteria(EmployeeInfo.class);
        List<EmployeeInfo> eList = criteria.list();
        System.out.println(eList);
        
        
        @SuppressWarnings("deprecation")
		Criteria cr = session.createCriteria(EmployeeInfo.class);
        cr.add(Restrictions.ge("salary", 27000.0));
        List<EmployeeInfo> elist1 = cr.list();
        System.out.println(elist1);
        
        @SuppressWarnings("deprecation")
		Criteria cr1 = session.createCriteria(EmployeeInfo.class);
        cr1.add(Restrictions.gt("salary", 27000.0));
        List<EmployeeInfo> elist2 = cr1.list();
        System.out.println(elist2);
        
        @SuppressWarnings("deprecation")
		Criteria cr2 = session.createCriteria(EmployeeInfo.class);
        cr2.add(Restrictions.le("salary", 27000.0));
        List<EmployeeInfo> elist3 = cr2.list();
        System.out.println(elist3);
        
        
        @SuppressWarnings("deprecation")
		Criteria cr3 = session.createCriteria(EmployeeInfo.class);
        cr3.add(Expression.ne("name", "Amol"));
        List<EmployeeInfo> elist4 = cr3.list();
        System.out.println(elist4);
        
        
        @SuppressWarnings("deprecation")
		Criteria cr4 = session.createCriteria(EmployeeInfo.class);
        List<Object> l = new ArrayList<Object>();
        l.add("1544");l.add("1255");
        cr4.add(Restrictions.in("empCode", l));
        cr4.addOrder(Order.desc("empCode"));
        List<EmployeeInfo> elist5= cr4.list();
        System.out.println(elist5);
        
        @SuppressWarnings("deprecation")
		Criteria cr5 = session.createCriteria(EmployeeInfo.class);
        cr5.add(Expression.eq("id", 5));
        EmployeeInfo employeeInfo = (EmployeeInfo) cr5.uniqueResult();
        System.out.println(employeeInfo);
        
        @SuppressWarnings("deprecation")
		Criteria cr6 = session.createCriteria(EmployeeInfo.class);
        cr6.add(Restrictions.between("joindate", "1-Jan-2021","31-Dec-2023"));
        cr6.addOrder(Order.desc("empCode"));
        List<EmployeeInfo> elist6= cr6.list();
        System.out.println(elist6);
	}
}
