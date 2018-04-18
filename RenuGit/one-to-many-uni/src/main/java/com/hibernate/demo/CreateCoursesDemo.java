package com.hibernate.demo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Course;
import com.hibernate.entity.Instructor;
import com.hibernate.entity.InstructorDetails;
import com.hibernate.entity.Student;

public class CreateCoursesDemo {
		
		public static void main(String args[]){
			
			SessionFactory factory = new Configuration().configure().addAnnotatedClass(Instructor.class).
					addAnnotatedClass(InstructorDetails.class).addAnnotatedClass(Course.class).buildSessionFactory();
			
			Session session = factory.getCurrentSession(); 
			
			session.beginTransaction();
			
			int id = 1;
			
			Instructor tempInstructor = session.get(Instructor.class, id);
			
			Course tempCourse = new Course("Air Hockey");
			Course tempCourse1 = new Course("Hockey");
			
			tempInstructor.add(tempCourse);
			tempInstructor.add(tempCourse1);
			
			session.save(tempCourse);
			session.save(tempCourse1);
			
			session.getTransaction().commit();
			
			session.close();
			factory.close();
						
		}

	}


