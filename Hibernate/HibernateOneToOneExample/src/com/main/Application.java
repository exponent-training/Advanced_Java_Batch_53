package com.main;

import java.util.Scanner;

import com.service.OperationI;
import com.service.OperationImpl;

public class Application {


	public static void main(String[] args) {


		Scanner sc = new Scanner(System.in);
		OperationI op = new OperationImpl();
		System.out.println("=============================  Application  Start ==========================");
		while(true) {
			System.out.println("A. Insert Data.");
			System.out.println("B. Get Data Using LoginId");

			String ch =sc.next();

			switch (ch) {
			case "A":
                op.insertLoginWithPersonData();
				break;
			case "B":
                op.getLoginWithPersonUsingLoginId();
				break;

			default:
				break;
			}
		}


	}

}
