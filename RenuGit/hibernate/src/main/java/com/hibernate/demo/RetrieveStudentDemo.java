package com.hibernate.demo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.hibernate.entity.Student;

public class RetrieveStudentDemo {
	
	public static void main(String args[]){
		
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession(); 
		
		System.out.println("Creating new student objects");
		
		Student student10 = new Student("Daffy","Duck", "daffy@gmail.com");
		
		session.beginTransaction();
		
		System.out.println("Saving the entry");
		session.save(student10);
		
		session.getTransaction().commit();
		System.out.println("Saving it to the DB");
		
		session = factory.getCurrentSession();
		session.beginTransaction();
		
		System.out.println("Retrieving the student information");
		
		Student mystudent = session.get(Student.class, student10.getId());
		
		System.out.println("Complete info" +mystudent);
		
		session.getTransaction().commit();
		
		factory.close();
		
	}

}
