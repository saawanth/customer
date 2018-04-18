package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Course;
import com.hibernate.entity.Instructor;
import com.hibernate.entity.InstructorDetails;
import com.hibernate.entity.Review;
import com.hibernate.entity.Student;

public class DeleteMaryDemo {

	public static void main(String args[]) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetails.class).addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class).addAnnotatedClass(Student.class).buildSessionFactory();

		Session session = factory.getCurrentSession();
		session.beginTransaction();

		int id = 1;
		
		Student theStudent = session.get(Student.class, id);
		
		System.out.println("Student" +theStudent);		
		System.out.println("The courses "+theStudent.getCourses());
		
		System.out.println("Deleting the student");
		session.delete(theStudent);
		
		session.getTransaction().commit();

		session.close();
		factory.close();

	}

}
