package com.main;

import java.util.Scanner;

import com.service.OperationI;
import com.service.OperationImpl;

public class Application {

	public static void main(String[] args) {

		OperationI op = new OperationImpl();
		Scanner sc =new Scanner(System.in);

		System.out.println("================================ Application Start ========================");
        boolean flag = true;
		while (flag) {

			System.out.println("1. Insert Employee Data With Company Data.");
			System.out.println("2. Insert Company Data With Employee Data.");
			System.out.println("3. Get Employee Data With Company Data using Employee Id.");
			System.out.println("4.  Get Company Data With Employee Data using Company Id.");
			System.out.println("5.  update Company Data With Employee Data using Company Id.");
			System.out.println("6.  update Employee Data With Company Data using Employee Id.");

			int ch =sc.nextInt();

			switch (ch) {
			case 1:
				op.insertEmployeeWithCompanyData();
				break;
			case 2:
				op.insertCompanyDataWithEmployeeData();
				break;
			case 3:
				op.getEmployeeDatawithCompanyDataUsingEmployeeId();
				break;
			case 4:
				op.getCompanyDataWithEmployeeDataUsingCompanyId();
				break;
				
			case 5:
				op.updateCompanyDataWithEmployeeDataUsingCompanyId();
				break;
			case 6:
				op.updateEmployeeDataWithCompanyDataUsingEmployeeId();
				break;
			default:  flag = false;
				break;
			}
		}
	}

}
