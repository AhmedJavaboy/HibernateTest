package com.simpleprogram;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtilities {
	public static SessionFactory sessionFactory;
	public static StandardServiceRegistry  standardRegistry;
	public static Metadata metaData ;
	
	static {
		
		try{
			
			standardRegistry= new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
			
			metaData=new MetadataSources(standardRegistry).getMetadataBuilder().build();
			sessionFactory = metaData.getSessionFactoryBuilder().build();
			
			
		}catch(HibernateException e){
			System.err.println("Proplem creating session Factory!");
		}catch(Exception e){
			System.err.println(e);
		}
	}
	
	public static SessionFactory getSessionFacory(){
		return sessionFactory;
		
	}
}
