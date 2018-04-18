package com.hibernate.demo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.hibernate.entity.Student;

public class UpdateStudentDemo {
	
	public static void main(String args[]){
		
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession(); 
		
		int studentID = 1;
			
		session = factory.getCurrentSession();
		session.beginTransaction();
		
		System.out.println("Retrieving the student information" +studentID);		
		Student mystudent = session.get(Student.class, studentID);		
		System.out.println("Updating the student");		
		mystudent.setFirstName("dobbu");		
		session.getTransaction().commit();
		
		session = factory.getCurrentSession();
		session.beginTransaction();
		
        session.createQuery("update Student set email='reva@gmail.com' where id = '2'").executeUpdate();
        
        session.getTransaction().commit();
		
		factory.close();
		
	}

}
