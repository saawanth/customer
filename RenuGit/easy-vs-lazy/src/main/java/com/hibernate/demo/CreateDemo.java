package com.hibernate.demo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Instructor;
import com.hibernate.entity.InstructorDetails;
import com.hibernate.entity.Student;

public class CreateDemo {
		
		public static void main(String args[]){
			
			SessionFactory factory = new Configuration().configure().addAnnotatedClass(Instructor.class).
					addAnnotatedClass(InstructorDetails.class).buildSessionFactory();
			
			Session session = factory.getCurrentSession(); 
			
			Instructor instrutor = new Instructor("Revanth", "Kovuri", "revanthkovuri@gmail.com");
			InstructorDetails instructordetails = new InstructorDetails("www.youtbe.com","farting");
			
			instrutor.setInstructorDetail(instructordetails);
			session.beginTransaction();
			
			System.out.println("Saving the entry");
			session.save(instrutor);
			
			session.getTransaction().commit();
			System.out.println("Saving it to the DB");
			
		}

	}


