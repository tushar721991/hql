package com.softedge.hql.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.softedge.hql.model.Employee;
import com.softedge.hql.model.Employee1;


public class SessionFactoryProvider {

	
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	static {
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure().build();
		sessionFactory = new MetadataSources(registry)
				.addAnnotatedClass(Employee.class)
				.addAnnotatedClass(Employee1.class)
				.buildMetadata().buildSessionFactory();
	}
}
