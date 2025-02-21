package com.controller;

import java.util.Scanner;

import com.service.ProductService;
import com.serviceImpl.ProductServiceImpl;

public class Application {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		ProductService p = new ProductServiceImpl();
		
		boolean flag = true;

		System.out.println("Application Started Choose your Respective option");
		while (flag) {
			System.out.println("a.additem");
			System.out.println("b.getProductById");
			System.out.println("c.updateProductById");
			System.out.println("d.DeleteProductById");
			System.out.println("x.Exit");

			char ch = sc.next().trim().charAt(0);

			switch (ch) {
			case 'a':
				p.additem();

				break;

			case 'b':
				p.getProductById();

				break;

			case 'c':
				p.updateProductById();

				break;
				
			case 'x' : flag = false;
			System.out.println("Application ended");
			break;
				
			default:
				break;
			}

		}
	}

}
