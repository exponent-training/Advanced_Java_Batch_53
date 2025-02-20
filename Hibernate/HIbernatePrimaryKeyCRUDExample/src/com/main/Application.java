package com.main;

import java.util.Scanner;

import com.service.OperationI;
import com.service.OperationImpl;

public class Application {
	
	public static void main(String[] args) {
		
		OperationI op = new OperationImpl();
		Scanner sc = new Scanner(System.in);
		System.out.println("==================== Application Started =======================");
		
		while(true) {
			System.out.println("1. Create Acoount Info. ");
			
			int ch = sc.nextInt();
			
		  switch (ch) {
		case 1: op.createAccountInfo();
			
			break;

		default:
			break;
		}
		}
		
	}

}
