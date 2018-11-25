package com.softedge.hql.client;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.softedge.hql.model.Employee;
import com.softedge.hql.util.SessionFactoryProvider;

public class EmployeeSelectClient {

	public static void main(String[] args) {
		SessionFactory factory = SessionFactoryProvider.getSessionFactory();
		Session session = factory.openSession();

		/*
		 * HQL - Hibernate query language In Hql we write class name instead of table
		 * name and properties of entity class instead of columns of a a table. To
		 * construct HQL query we have to use Query(I) interface SQL query = "select *
		 * from employees Hql query ="from Employee(Table Name)" list() method of
		 * Query(I) is for select peration
		 */
/*
//		Query<Employee> query = session.createQuery("from Employee", Employee.class);
		Query<Employee> query = session.createQuery("from Employee where employeeDepartment=?10", Employee.class);
		query.setParameter(10, "HR");

		Query<Employee> query = session.createQuery("from Employee where employeeDepartment=:dept and employeeId=?1", Employee.class);
		
		Query<Employee> query = session.createQuery("from Employee where employeeDepartment=:dept and employeeSalary between ?1 AND ?2", Employee.class);
		query.setParameter("dept", "HR");
		query.setParameter(1, 20000d);
		query.setParameter(2, 80000d);
		List<Employee> employees = query.list();
		for (Employee employee : employees) {
			System.out.println(employee);
		}*/
		
		
		//select perticular columns using HQL
		
		Query<Object[]> queryPerticular = session.createQuery("select employeeId, employeeName FROM Employee", Object[].class);
		List<Object[]> data = queryPerticular.list();

		for (Object[] row : data) {
			System.out.println(row[0]+"\t"+row[1]);
		}
		
		session.close();
		factory.close();
	}
}
