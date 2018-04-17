package hibernet.udemy.hibernetdemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernet.udemy.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			// Student theStudent = session.get(Student.class, 1);
			// session.delete(theStudent);
			session.createQuery("delete Student where id='3'").executeUpdate();
			session.getTransaction().commit();

		} finally {
			factory.close();

		}

	}

}
