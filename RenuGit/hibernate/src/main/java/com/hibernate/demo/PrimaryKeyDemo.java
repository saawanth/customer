package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String args[]) {

		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		System.out.println("Creating 3 student objects");

		Student student2 = new Student("Donkey", "reva", "paulVaughn@gmail.com");
		Student student3 = new Student("Kovuri", "Reva", "reva@gmail.com");
		Student student4 = new Student("Paul", "Walker", "paulwalker@gmail.com");

		session.beginTransaction();

		System.out.println("Saving the entry");
		session.save(student2);
		session.save(student3);
		session.save(student4);

		session.getTransaction().commit();
		System.out.println("Saving it to the DB");

	}
}
