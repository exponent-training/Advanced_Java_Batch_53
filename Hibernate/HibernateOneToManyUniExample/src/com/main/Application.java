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
			System.out.println("3. Get All User Data With AddToCart");
			System.out.println("4. Update User Data ");
			System.out.println("5. Update Addtocart ");

			int ch = sc.nextInt();

			switch (ch) {
			case 1:
				op.addingUserWithAddToCartData();
				break;
			case 2:
				op.getUserDataWithAddToCartUsingUserId();
				break;
			case 3:
				op.getAllUserDataWithAddToCart();;
				break;
			case 4:
				op.updateUserDataUsingUserID();
				break;
			case 5:
				op.updateAddToCartUsingUserId();
				break;
			default:
				break;
			}
		}


	}

}
