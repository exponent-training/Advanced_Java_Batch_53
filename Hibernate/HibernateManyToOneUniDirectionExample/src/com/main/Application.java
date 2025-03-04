package com.main;

import java.util.Scanner;

import com.service.OperartionImpl;
import com.service.OperationI;

public class Application {

	public static void main(String[] args) {

		Scanner sc =new Scanner(System.in);

		OperationI op = new OperartionImpl();


		System.out.println("================================ Application Start ==================================");


		while (true) {
			System.out.println("1. Add Digital Data With Person Data.");
			System.out.println("2. Get Digital Data With Person Data Using Digital Id");
			System.out.println("3. Get All Digital Data With Person Data");

			int ch = sc.nextInt();


			switch (ch) {
			case 1:
				op.addDigitalAccountDataWithPerson();
				break;
			case 2:
				op.getDigitalAccountDataWithPersonDataUsingDigitalId();
				break;
			case 3:
				op.getAllDigitalDataWithPersonData();
				break;
			default:
				break;
			}
		}
	}

}
