package com.tech.hibernateUtil;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

import com.tech.Admin;
import com.tech.Staff;
import com.tech.Transaction_Records;
import com.tech.Entity.Customer;

public class hibernateUtil {
	
		private static StandardServiceRegistry registry;
		
		private static SessionFactory sf;
		
		public static SessionFactory getSessionFactory() {
			
			Map<String, Object> setting=new HashMap<String, Object>();
			setting.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
			setting.put(Environment.URL, "jdbc:mysql://localhost:3306/BankProject01");
			setting.put(Environment.USER, "root");
			setting.put(Environment.PASS, "root");
			
			setting.put(Environment.HBM2DDL_AUTO, "update");
			setting.put(Environment.DIALECT, "org.hibernate.dialect.MySQL55Dialect");
			setting.put(Environment.SHOW_SQL, "true");
			
			registry=new StandardServiceRegistryBuilder().applySettings(setting).build();
			MetadataSources ms=new MetadataSources(registry)
					.addAnnotatedClass(Customer.class)
					.addAnnotatedClass(Admin.class)
					.addAnnotatedClass(Staff.class)
					.addAnnotatedClass(Transaction_Records.class);
			Metadata msd=ms.getMetadataBuilder().build();
			
			sf=msd.getSessionFactoryBuilder().build();
			
			return sf;
			
			
		}
	}
				
