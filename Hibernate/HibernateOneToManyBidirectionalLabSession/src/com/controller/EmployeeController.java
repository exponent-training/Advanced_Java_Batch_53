package com.controller;

import java.util.Scanner;

import co.service.EmployeeServiceImple;
import co.service.EmployeeServiceInterface;

public class EmployeeController {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		EmployeeServiceInterface ei = new EmployeeServiceImple();

		boolean flag = true;
		System.out.println("------------------Employee Application------------");

		while (flag) {
			System.out.println("-------------------------------------------------");
			System.out.println("1. insert employee with company.");
			System.out.println("2. getEmployeeWithCompany.");
			System.out.println("3. getAllDeatilsOfEmployeeCompany");
			System.out.println("4. getEmployeewithComapnyDataUsingEid");
			System.out.println("5. getComapnyDatawithEmployeeUsingcid");
			System.out.println("6. existingEmployeeAddingCompanyDetails");
			System.out.println("7. updateEmployeeUsingCompanyId");
			System.out.println("8. updateCompanyDetailsUsingEmployeeId");
			System.out.println("9. deleteEmployeeUsingCompanyId");
			System.out.println("10. deleteEmployeeUsingEmplyeeId");
			System.out.println("11. deleteCompanyUsingEmplyeeId");
			System.out.println("12. deleteEmployeeUsingEmplyeeId");
			System.out.println("13. Exit");
			System.out.println("-------------------------------------------------");

			System.out.println();
			System.out.println("Enter your choice:");
			int ch = sc.nextInt();

			switch (ch) {
			case 1:
				ei.insertEmployeeWithCompanyDetails();
				break;
			case 2:
				ei.getEmployeeWithCompany();
				break;
			case 3:
				ei.getAllDeatilsOfEmployeeCompany();
				break;
			case 4:
				ei.getEmployeewithComapnyDataUsingEid();
				break;
			case 5:
				ei.getComapnyDatawithEmployeeUsingcid();
				break;
			case 6:
				ei.existingEmployeeAddingCompanyDetails();
				break;
			case 7:
				ei.updateEmployeeUsingCompanyId();
				break;
			case 8:
				ei.updateCompanyDetailsUsingEmployeeId();
				break;
			case 9:
				ei.deleteEmployeeUsingCompanyId();
				break;
			case 10:
				ei.deleteEmployeeUsingEmplyeeId();
				break;
			case 11:
				ei.deleteCompanyUsingEmplyeeId();
				break;
			case 12:
				ei.deleteCompanyUsingCompanyId();
				break;
			case 13:
				flag = false;
				System.out.println("Thank you!!");
				break;
			default:
				break;
			}
		}

	}

}
