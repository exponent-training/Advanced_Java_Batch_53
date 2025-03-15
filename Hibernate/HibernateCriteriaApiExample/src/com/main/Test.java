package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.model.EmployeeInfo;
import com.util.HibernateUtil;

public class Test {
	
	public static void main(String[] args) {
		
		SessionFactory sf = HibernateUtil.getConnection();
		
		Session session = sf.openSession();
		
		EmployeeInfo employeeInfo = new EmployeeInfo();
		employeeInfo.setName("Amol");employeeInfo.setDesignation("Devloper");
		employeeInfo.setEmpCode("EMP1252");employeeInfo.setExperience(3);
		employeeInfo.setSalary(25000);employeeInfo.setJoindate("12-Feb-2021");
		
		EmployeeInfo employeeInfo1 = new EmployeeInfo();
		employeeInfo1.setName("Ajay");employeeInfo1.setDesignation("Devloper");
		employeeInfo1.setEmpCode("EMP1544");employeeInfo1.setExperience(4);
		employeeInfo1.setSalary(25000);employeeInfo1.setJoindate("12-Dec-2022");
		
		EmployeeInfo employeeInfo2 = new EmployeeInfo();
		employeeInfo2.setName("Amol");employeeInfo2.setDesignation("Devloper");
		employeeInfo2.setEmpCode("EMP1254");employeeInfo2.setExperience(3);
		employeeInfo2.setSalary(25000);employeeInfo2.setJoindate("12-Jan-2022");
		
		EmployeeInfo employeeInfo3 = new EmployeeInfo();
		employeeInfo3.setName("Nilesh");employeeInfo3.setDesignation("Devloper");
		employeeInfo3.setEmpCode("EMP3244");employeeInfo3.setExperience(8);
		employeeInfo3.setSalary(25000);employeeInfo3.setJoindate("25-Mar-2023");
		session.save(employeeInfo);
		
//		session.save(employeeInfo);session.save(employeeInfo1);session.save(employeeInfo2);
//		session.save(employeeInfo3);
		
		
	}

}
