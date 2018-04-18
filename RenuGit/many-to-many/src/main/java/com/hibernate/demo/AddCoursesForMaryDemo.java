package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Course;
import com.hibernate.entity.Instructor;
import com.hibernate.entity.InstructorDetails;
import com.hibernate.entity.Review;
import com.hibernate.entity.Student;

public class AddCoursesForMaryDemo {

	public static void main(String args[]) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetails.class).addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class).addAnnotatedClass(Student.class).buildSessionFactory();

		Session session = factory.getCurrentSession();
		session.beginTransaction();

		int id = 2;
		
		Student theStudent = session.get(Student.class, id);
		
		System.out.println("Student" +theStudent);		
		System.out.println("The courses "+theStudent.getCourses());
		
		Course thecourse = new Course("Paintball");
		Course thecourse1 = new Course("Furball");
		Course thecourse2 = new Course("Archery");
		Course thecourse3 = new Course("Shooting");

		thecourse.addStudent(theStudent);
		thecourse1.addStudent(theStudent);
		thecourse2.addStudent(theStudent);
		thecourse3.addStudent(theStudent);
		
		System.out.println("Saving the courses");
		
		session.save(thecourse);
		session.save(thecourse1);
		session.save(thecourse2);
		session.save(thecourse3);

		session.getTransaction().commit();

		session.close();
		factory.close();

	}

}
