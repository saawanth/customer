package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Course;
import com.hibernate.entity.Instructor;
import com.hibernate.entity.InstructorDetails;
import com.hibernate.entity.Review;
import com.hibernate.entity.Student;

public class CreateCoursesReviewDemo {

	public static void main(String args[]) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetails.class).addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		session.beginTransaction();

		Course tempCourse = new Course("Pacman");

		tempCourse.add(new Review("Great Course!"));
		tempCourse.add(new Review("Great Course!"));
		tempCourse.add(new Review("Such a waste of time!"));
		tempCourse.add(new Review("I scored the highest of all!"));

		System.out.println(tempCourse.getReview());

		session.save(tempCourse);

		session.getTransaction().commit();

		session.close();
		factory.close();

	}

}
