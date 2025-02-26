package com.main;

import java.util.Scanner;

import com.service.OperationI;
import com.service.OperationImpl;

public class Application {

	public static void main(String[] args) {


		Scanner sc = new Scanner(System.in);
		OperationI op = new OperationImpl();

		System.out.println("======================= Application Started ===========================");

		while(true) {
			System.out.println("1. Save Person Data.");
			System.out.println("2. Save Passport Data.");
			System.out.println("3. Get Person Data Using Passport Id.");
			System.out.println("4. Get Passport Data Using Person Id.");
			System.out.println("5. Get All Person Data.");
			System.out.println("6. Get All Passport Data.");

			int ch = sc.nextInt();

			switch (ch) {
			case 1:
                op.savePersonDataWithPassport();
				break;
			case 2:
                op.savePassportwithPersonData();
				break;
			case 3:
				op.getPersonDataByPassportId();
				break;
			case 4:
				op.getPassportDataByPersonId();
				break;
			case 5:
				op.getPersonAllDataWithPassportData();
				break;
			case 6:
				op.getPassportAllDataWithPersonData();
				break;
			default:
				break;
			}
		}


	}

}
