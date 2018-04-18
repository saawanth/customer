package com.hibernate.demo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.hibernate.entity.Student;

public class CreateStudentDemo {
	
	public static void main(String args[]){
		
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession(); 
		
		System.out.println("Creating new student objects");
		
		Student student1 = new Student("Paul","Vaughn", "paulVaughn@gmail.com");
		
		session.beginTransaction();
		
		System.out.println("Saving the entry");
		session.save(student1);
		
		session.getTransaction().commit();
		System.out.println("Saving it to the DB");
		
	}

}
