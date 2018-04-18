 package com.hibernate.demo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Instructor;
import com.hibernate.entity.InstructorDetails;
import com.hibernate.entity.Student;

public class DeleteDemo2 {
		
		public static void main(String args[]){
			
			SessionFactory factory = new Configuration().configure().addAnnotatedClass(Instructor.class).
					addAnnotatedClass(InstructorDetails.class).buildSessionFactory();
			
			Session session = factory.getCurrentSession(); 
			
			session.beginTransaction();
			
			int id = 3;
			
			InstructorDetails instrutorDetails = session.get(InstructorDetails.class, id);
			
			System.out.println("Instructor Details" + instrutorDetails);
			
			System.out.println("Associated instructor details" + instrutorDetails.getInstructor());
			
			session.delete(instrutorDetails);
			
			instrutorDetails.getInstructor().setInstructorDetail(null);
			
			session.getTransaction().commit();
			System.out.println("Saving it to the DB");
			
		}

	}


