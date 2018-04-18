package com.hibernate.demo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.hibernate.entity.Student;

public class DeleteStudentDemo {
	
	public static void main(String args[]){
		
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession(); 
		
		int studentID = 4;
			
		session = factory.getCurrentSession();
		session.beginTransaction();
		
		System.out.println("Deleting the student information" +studentID);		
		Student mystudent = session.get(Student.class, studentID);		
		System.out.println("Deleting the student");		
//		session.delete(mystudent);	
		
		session.createQuery("delete from Student where id='5'").executeUpdate();
		
		session.getTransaction().commit();
		
		factory.close();
		
	}

}
