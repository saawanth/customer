package hibernet.udemy.hibernetdemo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernet.udemy.entity.Student;

public class StudentDemo {
	public static void main(String args[]) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			List<Student> theStudents = session.createQuery("from Student").list();
			displayStudents(theStudents);

			theStudents = session.createQuery("from Student s where s.lastName='Kov'").list();
			displayStudents(theStudents);

			theStudents = session.createQuery("from Student s where" + " s.lastName='Ko' OR s.firstName='Reva'").list();
			displayStudents(theStudents);

			theStudents = session.createQuery("from Student s where" + " s.email LIKE '%@gmai.com'").list();
			displayStudents(theStudents);

			session.getTransaction().commit();

		} finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> theStudents) {
		for (Student student : theStudents) {
			System.out.println(student);
		}
	}
}
