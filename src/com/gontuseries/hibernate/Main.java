package com.gontuseries.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main 
{
	public static void main(String args[])
	{
		StudentCertification studentCertification1 = new StudentCertification();
		studentCertification1.setCertification_name("Core Java Certification Exam");
		
		StudentCertification studentCertification2 = new StudentCertification();
		studentCertification2.setCertification_name("Oracle DB Certification Exam");
		
		Student student1 =new Student();
		student1.setStudent_name("Gontu1");
		(student1.getStudentCertification()).add(studentCertification1);
		
		Student student2 =new Student();
		student2.setStudent_name("Gontu2");
		(student2.getStudentCertification()).add(studentCertification2);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session =sessionFactory.openSession();
		session.beginTransaction();
		
		session.save(student1);
		session.save(student2);
		
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}
}
