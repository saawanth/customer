package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Course;
import com.hibernate.entity.Instructor;
import com.hibernate.entity.InstructorDetails;
import com.hibernate.entity.Review;
import com.hibernate.entity.Student;

public class GetCoursesReviewDemo {

	public static void main(String args[]) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetails.class).addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		session.beginTransaction();

		int id = 11;
		
		Course tempCourse = session.get(Course.class, id);
		
		System.out.println("Course details "+tempCourse);
		
		System.out.println(tempCourse.getReview());
		
		session.getTransaction().commit();

		session.close();
		factory.close();

	}

}
