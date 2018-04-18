package com.hibernate.demo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Course;
import com.hibernate.entity.Instructor;
import com.hibernate.entity.InstructorDetails;
import com.hibernate.entity.Student;

public class CreateInstructorDemo {
		
		public static void main(String args[]){
			
			SessionFactory factory = new Configuration().configure().addAnnotatedClass(Instructor.class).
					addAnnotatedClass(InstructorDetails.class).addAnnotatedClass(Course.class).buildSessionFactory();
			
			Session session = factory.getCurrentSession(); 
			
			Instructor instrutor = new Instructor("Susan", "Konidela", "susanKonidela@gmail.com");
			InstructorDetails instructordetails = new InstructorDetails("www.youtbe.com","video gaming");
			
			instrutor.setInstructorDetail(instructordetails);
			session.beginTransaction();
			
			System.out.println("Saving the entry");
			session.save(instrutor);
			
			session.getTransaction().commit();
			
			session.close();
			factory.close();
						
		}

	}


