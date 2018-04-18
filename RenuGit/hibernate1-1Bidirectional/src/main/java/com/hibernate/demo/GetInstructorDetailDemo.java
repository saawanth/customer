package com.hibernate.demo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Instructor;
import com.hibernate.entity.InstructorDetails;
import com.hibernate.entity.Student;

public class GetInstructorDetailDemo {
		
		public static void main(String args[]){
			
			SessionFactory factory = new Configuration().configure().addAnnotatedClass(Instructor.class).
					addAnnotatedClass(InstructorDetails.class).buildSessionFactory();
			
			Session session = factory.getCurrentSession(); 
			
			session.beginTransaction();
			
			int id = 2;
			
			InstructorDetails instrutorDetails = session.get(InstructorDetails.class, id);
			
			System.out.println("Instructor Details" + instrutorDetails);
			
			System.out.println("Associated instructor details" + instrutorDetails.getInstructor());
			
			session.getTransaction().commit();
			System.out.println("Saving it to the DB");
			
		}

	}


