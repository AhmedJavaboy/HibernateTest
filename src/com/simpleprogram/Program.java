package com.simpleprogram;

import java.util.Date;
import java.util.Map.Entry;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Program {
	public static void main(String[] args){
		System.out.println("Hello world!");
		
		Session session= HibernateUtilities.getSessionFacory().openSession();
		
		session.beginTransaction();
		User user =new User();
		user.setName("Ahmed");
		user.getHistory().put("GL123",new UserHistory(new Date(),"Set Name to Ahmed"));
		user.getProteinData().setGoal(250);
		user.getHistory().put("GL124",new UserHistory(new Date(),"Set Goal to 250"));
		session.save(user);
		session.getTransaction().commit();
		
		session.beginTransaction();
		User loadeduser=(User)session.get(User.class,1);
		System.out.println(loadeduser.getName());
		System.out.println(loadeduser.getProteinData().getGoal());
		for (Entry<String,UserHistory> history : loadeduser.getHistory().entrySet()) {
			System.out.println(history.getValue().toString()+ " "+ history.getValue());
		}
		
		loadeduser.getProteinData().setTotal(loadeduser.getProteinData().getTotal()+50);
		loadeduser.getHistory().put("GL125",new UserHistory(new Date(),"Set Total to 50"));
		session.getTransaction().commit();
		
		session.close();
		HibernateUtilities.getSessionFacory().close();
	}
}
