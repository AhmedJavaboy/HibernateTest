package com.simpleprogram;

import java.util.Date;
import org.hibernate.Session;

public class Program {
	public static void main(String[] args){
		System.out.println("Hello world!");
		
		Session session= HibernateUtilities.getSessionFacory().openSession();
		
		session.beginTransaction();
		User user =new User();
		user.setName("Ahmed");
		user.getHistory().add(new UserHistory(new Date(),"Set Name to Ahmed"));
		user.getProteinData().setGoal(250);
		user.getHistory().add(new UserHistory(new Date(),"Set Goal to 250"));
		session.save(user);
		session.getTransaction().commit();
		
		session.beginTransaction();
		User loadeduser=(User)session.get(User.class,1);
		System.out.println(loadeduser.getName());
		System.out.println(loadeduser.getProteinData().getGoal());
		for (UserHistory history : loadeduser.getHistory()) {
			System.out.println(history.getEntryTime().toString()+ " "+ history.getEntry());
		}
		
		loadeduser.getProteinData().setTotal(loadeduser.getProteinData().getTotal()+50);
		loadeduser.getHistory().add(new UserHistory(new Date(),"Set Total to 50"));
		session.getTransaction().commit();
		
		session.close();
		HibernateUtilities.getSessionFacory().close();
	}
}
