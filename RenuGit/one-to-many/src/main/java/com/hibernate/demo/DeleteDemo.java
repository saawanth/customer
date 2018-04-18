package com.hibernate.demo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Instructor;
import com.hibernate.entity.InstructorDetails;
import com.hibernate.entity.Student;

public class DeleteDemo {
		
		public static void main(String args[]){
			
			SessionFactory factory = new Configuration().configure().addAnnotatedClass(Instructor.class).
					addAnnotatedClass(InstructorDetails.class).buildSessionFactory();
			
			int id = 1;
			
			Session session = factory.getCurrentSession(); 
			
			session.beginTransaction();
			
			Instructor instructor = session.get(Instructor.class, id);
			
			if(instructor != null){
				
				System.out.println("Deleting the instructor");
				session.delete(instructor);
			}
			
			session.getTransaction().commit();
			System.out.println("Saving it to the DB");
			
		}

	}


