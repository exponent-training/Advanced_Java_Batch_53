package com.main;

import java.util.Scanner;

import com.service.OperartionI;
import com.service.OperationImpl;

public class Application {

	public static void main(String[] args) {


		OperartionI op = new OperationImpl();

		Scanner sc = new Scanner(System.in);


		System.out.println("========================== Applicatin Start ======================================");


		while(true) {
			System.out.println("1. Insert StuentData with Courses Data.");
			System.out.println("2. Get Student Data With Course Data.");
			System.out.println("3. Get All Student Data With Course Data.");
			System.out.println("4. Insert individual Student Data.");
			System.out.println("5. Insert individual Course Data.");
			System.out.println("6. Adding Existing Course to Student data.");

			int ch = sc.nextInt();
			switch (ch) {
			case 1:
				op.saveStudentDataWithCourseData();
				break;
			case 2:
				op.getSingleStudentData();
				break;
			case 3:
				op.getAllStudentData();
				break;
			case 4:
				op.saveIndividualStudentData();
				break;
			case 5:
				op.saveIndividualCourseData();
				break;
			case 6:
				op.addExistingCourseToStudent();
				break;
			default:
				break;
			}
		}
	}

}
