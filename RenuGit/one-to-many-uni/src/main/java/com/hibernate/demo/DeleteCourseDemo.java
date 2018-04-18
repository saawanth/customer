package com.hibernate.demo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Course;
import com.hibernate.entity.Instructor;
import com.hibernate.entity.InstructorDetails;
import com.hibernate.entity.Student;

public class DeleteCourseDemo {
		
		public static void main(String args[]){
			
			SessionFactory factory = new Configuration().configure().addAnnotatedClass(Instructor.class).
					addAnnotatedClass(InstructorDetails.class).addAnnotatedClass(Course.class).buildSessionFactory();
			
			Session session = factory.getCurrentSession(); 
			
			session.beginTransaction();
			
			int id = 10;
			
			Course courses = session.get(Course.class, id);
			
			session.delete(courses);
			
			session.getTransaction().commit();
			
			session.close();
			factory.close();
						
		}

	}


