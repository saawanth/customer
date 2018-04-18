package com.hibernate.demo;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.hibernate.entity.Student;

public class QueryStudentDemo {
	
	public static void main(String args[]){
		
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession(); 
		
		
		session.beginTransaction();
		
		List<Student> theStudent = session.createQuery("from Student").getResultList();
		
		displayStudents(theStudent);
		
		theStudent = session.createQuery("from Student s where s.lastName = 'reva'").getResultList();
		
		displayStudents(theStudent);
		
		theStudent = session.createQuery("from Student s where" + " s.lastName = 'reva' OR s.firstName = 'Paul'").getResultList();
		
		displayStudents(theStudent);
		
		theStudent = session.createQuery("from Student s where s.email LIKE '%@gmail.com'").getResultList();
		
		displayStudents(theStudent);
		
		session.getTransaction().commit();
		System.out.println("Saving it to the DB");
		
	}

	private static void displayStudents(List<Student> theStudent) {
		for(Student temp: theStudent){
			System.out.println(temp);
		}
	}

}
