package com.softedge.hql.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.softedge.hql.util.SessionFactoryProvider;

public class EmployeeInsertClient {

	public static void main(String[] args) {
		SessionFactory factory = SessionFactoryProvider.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("INSERT INTO Employee1(employeeId, employeeName) SELECT employeeId, employeeName FROM Employee");
		int count = query.executeUpdate();
		System.out.println("Number of rows inserted :: "+ count);
/*		Employee e1 = new Employee(101, "John Doe", "HR",              LocalDate.now(), 30000);
		Employee e2 = new Employee(102, "Alex Colin", "IT",            LocalDate.parse("2015-03-24"), 40000);
		Employee e3 = new Employee(103, "Bob Martin", "Developer",     LocalDate.parse("2014-12-31"), 50000);
		Employee e4 = new Employee(104, "Jason Taylor", "HR",          LocalDate.parse("2016-08-26"), 60000);
		Employee e5 = new Employee(105, "John Parker", "HR",           LocalDate.parse("2016-05-14"), 70000);

		session.save(e1);
		session.save(e2);
		session.save(e3);
		session.save(e4);
		session.save(e5);
*/
		tx.commit();
		session.close();
		factory.close();
	}
}
