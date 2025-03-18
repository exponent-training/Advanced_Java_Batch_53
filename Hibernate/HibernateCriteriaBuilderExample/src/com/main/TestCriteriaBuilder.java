package com.main;

import java.util.Iterator;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.model.Employee;
import com.model.Student;
import com.util.HibernateUtil;

public class TestCriteriaBuilder {

	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSessionFactory();

		Session session = sf.openSession();

		//select * from employee;

		CriteriaBuilder builder = session.getCriteriaBuilder();

		CriteriaQuery<Employee> criteriaQuery = builder.createQuery(Employee.class);

		Root<Employee> root = criteriaQuery.from(Employee.class);
		criteriaQuery.select(root);

		Query<Employee> query = session.createQuery(criteriaQuery);
		List<Employee> list = query.getResultList();

		System.out.println(list);

		//select * from employee where id = ?

		CriteriaBuilder builder2 = session.getCriteriaBuilder();

		CriteriaQuery<Employee> criteriaQuery2 = builder2.createQuery(Employee.class);

		Root<Employee> root1 = criteriaQuery2.from(Employee.class);
		criteriaQuery2.select(root1).where(builder2.equal(root.get("id"), 1));

		Query<Employee> query2 = session.createQuery(criteriaQuery2);
		Employee employee = query2.getSingleResult();
		System.out.println(employee);

		//select name from employee;

		CriteriaBuilder builder3 = session.getCriteriaBuilder();

		CriteriaQuery<String> criteriaQuery3 = builder3.createQuery(String.class);

		Root<Employee> root2 = criteriaQuery3.from(Employee.class);
		criteriaQuery3.select(root2.get("name"));

		Query<String>  query3 = session.createQuery(criteriaQuery3);
		List<String> nameList = query3.getResultList();
		System.out.println(nameList);

		//select name,designation from employee;

		CriteriaBuilder builder4 = session.getCriteriaBuilder();

		CriteriaQuery<Object[]> criteriaQuery4 = builder4.createQuery(Object[].class);

		Root<Employee> root3 = criteriaQuery4.from(Employee.class);
		criteriaQuery4.multiselect(root3.get("name"),root3.get("designation"));

		Query<Object[]>  query4 = session.createQuery(criteriaQuery4);
		List<Object[]> elist = query4.getResultList();
		for (Object[] objects : elist) {
			System.out.println("Name : " + objects[0]);
			System.out.println("Designation : " + objects[1]);
		}


		//update and delete
		// Multitable Selection operation

		CriteriaBuilder builder5 = session.getCriteriaBuilder();

		CriteriaQuery<Object[]> allCriteriaQuery = builder5.createQuery(Object[].class);

		Root<Employee> empRoot = allCriteriaQuery.from(Employee.class);

		Root<Student> stuRoot = allCriteriaQuery.from(Student.class);

		allCriteriaQuery.multiselect(empRoot,stuRoot)
		.where(builder5.equal(empRoot.get("id"), stuRoot.get("id")));

		Query<Object[]> query5 = session.createQuery(allCriteriaQuery);

		List<Object[]> oList = query5.getResultList();

		for (Object[] objects : oList) {
			Employee emp = (Employee) objects[0];
			System.out.println(emp);
			Student stu = (Student) objects[1];
			System.out.println(stu);
		}
	}
}
