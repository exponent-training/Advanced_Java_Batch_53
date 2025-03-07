package com.service;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.model.CompanyDetails;
import com.model.Employee;
import com.util.HibernateUtil;

public class OperationImpl implements OperationI{

	SessionFactory sf = HibernateUtil.getConnection();
	Scanner sc =new Scanner(System.in);


	@Override
	public void insertEmployeeWithCompanyData() {

		Session session = sf.openSession();

		Employee employee = new Employee();

		System.out.println("Enter Employee Name :");
		employee.setEname(sc.next());

		System.out.println("Enter Employee Address :");
		employee.setEaddress(sc.next());

		System.out.println("Provide no of company Details : ");
		int no = sc.nextInt();
		for(int i = 0 ; i < no ; i++ ) {
			CompanyDetails companyDetails = new CompanyDetails();

			System.out.println("Enter Company Name : ");
			companyDetails.setCname(sc.next());

			System.out.println("Enter Company Join Date : ");
			companyDetails.setJoindate(sc.next());

			System.out.println("Enter Company Experience : ");
			companyDetails.setExpYear(sc.next());

			employee.getCompanyDetails().add(companyDetails);

			companyDetails.setEmployee(employee);

			session.save(companyDetails);
			session.save(employee);

			session.beginTransaction().commit();

		}

		System.out.println("Data Save");
	}

	@Override
	public void insertCompanyDataWithEmployeeData() {
		// TODO Auto-generated method stub

	}

	@Override
	public void getEmployeeDatawithCompanyDataUsingEmployeeId() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		System.out.println("Enter Employee Id : ");
		int id = sc.nextInt();
		Employee employee = session.get(Employee.class, id);
		System.out.println(employee);

	}

	@Override
	public void getCompanyDataWithEmployeeDataUsingCompanyId() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		System.out.println("Enter Company Id : ");
		int id = sc.nextInt();
		CompanyDetails companyDetails = session.get(CompanyDetails.class, id);
		System.out.println(companyDetails);
		System.out.println(companyDetails.getEmployee().getEname());
	}

	@Override
	public void ExistingEmployeeAddingCompanyDetails() {
		// TODO Auto-generated method stub

	}

	@Override
	public void getAllEmployeeData() {
		// TODO Auto-generated method stub

	}

	@Override
	public void getAllCompanyDaetals() {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateCompanyDataWithEmployeeDataUsingCompanyId() {
		// TODO Auto-generated method stub
		Session session = sf.openSession();
		System.out.println("Enter Company Id : ");
		int cid = sc.nextInt();
		CompanyDetails companyDetails = session.get(CompanyDetails.class, cid);

		if(companyDetails != null) {
			boolean flag = true;
			while(flag) {
				System.out.println("1. Do you want update Company Data.");
				System.out.println("2. Do you want update Employee Data.");

				int ch = sc.nextInt();

				switch (ch) {
				case 1:
					updateCompanyData(companyDetails,sc,session);
					break;
				case 2:

					break;
				default: flag = false;
					break;
				}
			}



		} else {
			System.out.println("No Company Data Found.");
		}
	}

	@Override
	public void updateEmployeeDataWithCompanyDataUsingEmployeeId() {
		// TODO Auto-generated method stub

	}

	
	private static void updateCompanyData(CompanyDetails companyDetails,Scanner sc,Session session) {
		if(companyDetails != null) {
			System.out.println("Enter updated Company Name :");
			companyDetails.setCname(sc.next());
			session.update(companyDetails);
			session.beginTransaction().commit();
		} else {
			System.out.println("No Company Data Found for updating.");
		}
	}
}
