package com.softedge.hql.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.softedge.hql.util.SessionFactoryProvider;

public class EmployeeUpdateAndDeleteClient {

	public static void main(String[] args) {
		SessionFactory factory = SessionFactoryProvider.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		/*
		 * Update using HQL
		Query query = session.createQuery("UPDATE Employee SET employeeDepartment=?0, employeeSalary=?1 WHERE employeeId=?2");
		query.setParameter(0,  "HR");
		query.setParameter(1,  9999d);
		query.setParameter(2,  102);
		
		int count = query.executeUpdate();
		System.out.println("Number of rows affected :: "+ count);
		*/
		
		// delete using HQL
		Query query = session.createQuery("DELETE FROM Employee WHERE employeeId=?0");
		query.setParameter(0,  102);

		int count = query.executeUpdate();
		System.out.println("Number of rows deleted :: "+ count);
		

		tx.commit();
		session.close();
		factory.close();
	}
}
