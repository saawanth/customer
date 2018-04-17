package hibernet.udemy.hibernetdemo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import hibernet.udemy.entity.Student;

public class UpdateStudentDemo {

	public static void main(String args[]) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			Student theStudent = session.get(Student.class, 1);
			theStudent.setFirstName("Scooby");
			session.getTransaction().commit();

			session = factory.getCurrentSession();
			session.beginTransaction();
			session.createQuery("update Student s set email='revanth@gmail.com' where" + " s.firstName='reva'" ).executeUpdate();

			session.getTransaction().commit();
		} finally {
			factory.close();
		}
	}
}
