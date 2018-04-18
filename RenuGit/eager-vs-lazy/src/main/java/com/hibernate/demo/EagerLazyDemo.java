package com.hibernate.demo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Course;
import com.hibernate.entity.Instructor;
import com.hibernate.entity.InstructorDetails;
import com.hibernate.entity.Student;

public class EagerLazyDemo {
		
		public static void main(String args[]){
			
			SessionFactory factory = new Configuration().configure().addAnnotatedClass(Instructor.class).
					addAnnotatedClass(InstructorDetails.class).addAnnotatedClass(Course.class).buildSessionFactory();
			
			Session session = factory.getCurrentSession(); 
			
			session.beginTransaction();
			
			int id = 1;
			
			Instructor tempInstructor = session.get(Instructor.class, id);
			
			System.out.println("Instructor Courses" +tempInstructor);
			
//			System.out.println("Give me!" +tempInstructor.getCourse());
			
			session.getTransaction().commit();
			
			session.close();
			factory.close();
						
		}

	}


