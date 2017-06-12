package com.simpleprogram;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Program {
	public static void main(String[] args){
		System.out.println("Hello world!");
		
		SessionFactory sf =  HibernateUtilities.getSessionFacory();
		Session session=sf.openSession();
		session.beginTransaction();
		
		User user =new User();
		user.setName("Ahmed");
		user.setGoal(250);
		session.save(user);
		
		session.getTransaction().commit();
		session.close();
		HibernateUtilities.getSessionFacory().close();
	}
}
