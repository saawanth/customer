package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Course;
import com.hibernate.entity.Instructor;
import com.hibernate.entity.InstructorDetails;
import com.hibernate.entity.Review;
import com.hibernate.entity.Student;

public class CreateCoursesStudentDemo {

	public static void main(String args[]) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetails.class).addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class).addAnnotatedClass(Student.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		session.beginTransaction();

		Course tempCourse = new Course("Pacman");
		
		session.save(tempCourse);
		
		Student tempStudent = new Student("Renu", "Kappara", "renur@gmail.com");
		Student tempStudent1 = new Student("Revan", "Kovuri", "renur@gmail.com");
		
		tempCourse.addStudent(tempStudent);
		tempCourse.addStudent(tempStudent1);
		
		session.save(tempStudent);
		session.save(tempStudent1);
		
		System.out.println("Saved the students "+tempCourse.getStudents());

		session.getTransaction().commit();

		session.close();
		factory.close();

	}

}
