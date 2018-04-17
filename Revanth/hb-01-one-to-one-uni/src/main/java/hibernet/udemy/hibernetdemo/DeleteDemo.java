package hibernet.udemy.hibernetdemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernet.udemy.entity.Instructor;
import hibernet.udemy.entity.InstructorDetail;

public class DeleteDemo {
	public static void main(String args[]) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			System.out.println("creating object.......");

			Instructor instructor = session.get(Instructor.class, 1);
			session.delete(instructor);

			session.getTransaction().commit();
			System.out.println("commit!");

		} finally {
			factory.close();
		}
	}

}
