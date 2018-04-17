package hibernet.udemy.hibernetdemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernet.udemy.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			Student student1 = new Student("Revanth", "Kovuri", "rev@gmail.com");
			Student student2 = new Student("rev", "kov", "rev@gmail.com");

			session.beginTransaction();

			System.out.println(student1);
			session.save(student1);
			session.save(student2);

			session.getTransaction().commit();
			System.out.println(student1);

			session = factory.getCurrentSession();
			session.beginTransaction();

			Student getStudent = session.get(Student.class, student1.getId());

			session.getTransaction().commit();

			System.out.println(getStudent);

		} finally {
			factory.close();

		}
	}

}
