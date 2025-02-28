package com.main;

import java.util.Scanner;

import com.service.OperationI;
import com.service.operationImpl;

public class Application {

	public static void main(String[] args) {


		Scanner sc = new Scanner(System.in);

		OperationI op = new operationImpl();

		while(true) {
			System.out.println("1. Add Data User and AddToCart");
			System.out.println("2. Get Data Using User Id With AddToCart");

			int ch = sc.nextInt();

			switch (ch) {
			case 1:
				op.addingUserWithAddToCartData();
				break;
			case 2:
				op.getUserDataWithAddToCartUsingUserId();
				break;
			default:
				break;
			}
		}


	}

}
