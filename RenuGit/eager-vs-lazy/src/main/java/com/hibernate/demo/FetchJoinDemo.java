package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.hibernate.entity.Course;
import com.hibernate.entity.Instructor;
import com.hibernate.entity.InstructorDetails;
import com.hibernate.entity.Student;

public class FetchJoinDemo {

	public static void main(String args[]) {

		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetails.class).addAnnotatedClass(Course.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		session.beginTransaction();

		int id = 1;

		Query<Instructor> query = session.createQuery(
				"select i from Instructor i " + "JOIN FETCH i.course " + "where i.id=:theInstructorId",
				Instructor.class);
		
		query.setParameter("theInstructorId", id);
		
		Instructor instructor = query.getSingleResult();
		
		System.out.println("The instructor "+ instructor);

		session.getTransaction().commit();

		session.close();
		factory.close();

	}

}
