package co.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.Entity.CompanyDetails;
import com.Entity.Employee;
import com.util.HibernateUtil;

public class EmployeeServiceImple implements EmployeeServiceInterface{

	SessionFactory sf = HibernateUtil.getSessionFactory();
	Scanner sc = new Scanner(System.in);
	@Override
	public void insertEmployeeWithCompanyDetails() {
		Session session = sf.openSession();
		Employee e = new Employee();
		System.out.println("Enter ename:");
		e.setName(sc.next());
		System.out.println("Enter address:");
		e.setAddress(sc.next());
		System.out.println("Enter no. of companies:");
		int n = sc.nextInt();
		List<CompanyDetails> list = new ArrayList<CompanyDetails>();
		for(int i = 1; i<=n;i++) {
			
			CompanyDetails c = new CompanyDetails();
			
			System.out.println("Enter cname:");
			c.setCname(sc.next());
			System.out.println("Enter joining date:");
			c.setJoiningdate(sc.next());
			System.out.println("Enter experience:");
			c.setExperience(sc.next());
			c.setEmployee(e);
			list.add(c);
		}
		e.setListOfCompany(list);
		session.save(e);
		session.beginTransaction().commit();
		System.out.println("success!!");
	}

	@Override
	public void getEmployeeWithCompany() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getAllDeatilsOfEmployeeCompany() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getEmployeewithComapnyDataUsingEid() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getComapnyDatawithEmployeeUsingcid() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void existingEmployeeAddingCompanyDetails() {
		Session session =sf.openSession();
		System.out.println("enter employee id:");
		int eid = sc.nextInt();
		Employee emp = session.get(Employee.class, eid);
		if (emp !=null) {
			System.out.println("Enter no. of companies:");
			int n = sc.nextInt();
			List<CompanyDetails> list = emp.getListOfCompany();
			for(int i = 1; i<=n;i++) {
				
				CompanyDetails c = new CompanyDetails();
				
				System.out.println("Enter cname:");
				c.setCname(sc.next());
				System.out.println("Enter joining date:");
				c.setJoiningdate(sc.next());
				System.out.println("Enter experience:");
				c.setExperience(sc.next());
				c.setEmployee(emp);
				list.add(c);
			}
			session.save(emp);
			session.beginTransaction().commit();
			System.out.println("successfully saved!!");
		} else {
			System.out.println("employee does not exist!!");
		}
		
	}

	@Override
	public void updateEmployeeUsingCompanyId() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateCompanyDetailsUsingEmployeeId() {
		Session session = sf.openSession();
		System.out.println("enter empid:");
		Employee emp =session.get(Employee.class, sc.nextInt());
		if (emp !=null) {
			List<CompanyDetails> list = emp.getListOfCompany();
			System.out.println("enter cid that you want update:");
			int cidIn = sc.nextInt();
			for (CompanyDetails companyDetails : list) {
				if (companyDetails != null && cidIn == companyDetails.getCid()) {
					System.out.println("enter updated cname:");
					companyDetails.setCname(sc.next());
					System.out.println("enter updated joiningdate:");
					companyDetails.setJoiningdate(sc.next());
					System.out.println("enter updated experience:");
					companyDetails.setExperience(sc.next());
					session.update(companyDetails);
					session.beginTransaction().commit();
					System.out.println("successfully updated!!");
				} 
			}
			
		} else {
			System.out.println("employee does not exist!!");
		}

	}

	@Override
	public void deleteEmployeeUsingCompanyId() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteEmployeeUsingEmplyeeId() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCompanyUsingEmplyeeId() {
		Session session = sf.openSession();
		System.out.println("enter empid:");
		Employee emp =session.get(Employee.class, sc.nextInt());
		CompanyDetails company_delete = null;
		if (emp !=null) {
			List<CompanyDetails> list = emp.getListOfCompany();
			System.out.println("enter cid that you want delete:");
			int cidIn = sc.nextInt();
			for (CompanyDetails companyDetails : list) {
				if (companyDetails != null && cidIn == companyDetails.getCid()) {
					companyDetails.setEmployee(null);
					company_delete = companyDetails;					
				} 
			}
			list.remove(company_delete);
			emp.setListOfCompany(list);
			session.update(emp);
			session.delete(company_delete);
			session.beginTransaction().commit();
			System.out.println("success!!");
			
		} else {
			System.out.println("employee does not exist!!");
		}

		
	}

	@Override
	public void deleteCompanyUsingCompanyId() {
		// TODO Auto-generated method stub
		
	}
	
	

}
