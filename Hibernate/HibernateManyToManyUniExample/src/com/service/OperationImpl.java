package com.service;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.entity.Course;
import com.entity.Student;
import com.util.HibernateUtil;

public class OperationImpl implements OperartionI{

	SessionFactory sf = HibernateUtil.getSessionFactory();

	@Override
	public void saveStudentDataWithCourseData() {
		Session session = sf.openSession();
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter no of student");
		int sno = sc.nextInt();

		for(int i = 0 ; i < sno ; i++) {
			Student student = new Student();
			System.out.println("Enter Student Name : ");
			student.setSname(sc.next());
			System.out.println("Enter Student Addess");
			student.setAddress(sc.next());

			System.out.println("Enter No courses.");

			int cno = sc.nextInt();
			for(int j = 0 ; j < cno ; j++) {
				Course course = new Course();

				System.out.println("Provide Course Id : ");
				int cid = sc.nextInt();

				Course course2 = session.get(Course.class, cid);
				if(course2 != null) {
					student.getCourses().add(course2);
				} else {
					System.out.println("Enter Course Name : ");
					course.setCname(sc.next());
					System.out.println("Enter Course Mode : ");
					course.setCmode(sc.next());
					student.getCourses().add(course);
				}
			}
			session.save(student);
			session.beginTransaction().commit();
			System.out.println("Data Store.");
		}

	}

	@Override
	public void getSingleStudentData() {
		// TODO Auto-generated method stub

	}

	@Override
	public void getAllStudentData() {
		// TODO Auto-generated method stub

	}

	@Override
	public void saveIndividualStudentData() {
		// TODO Auto-generated method stub

	}

	@Override
	public void saveIndividualCourseData() {
		// TODO Auto-generated method stub

	}

	@Override
	public void addExistingCourseToStudent() {
		// TODO Auto-generated method stub
	  //Logical flow
      //1. provide student id
		//2. if already course mapped provide appropriate console msg.
		//3.else  Mapping  Course but if remaining courses check
		//adding in case other remaining course need adding new course then provide new course object .
		//4. then newly added course mapping with student.
	}

}
