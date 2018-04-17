package hibernet.udemy.hibernetdemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernet.udemy.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			Student student1 = new Student("Revant", "Kovur", "rev@gmail.com");
			Student student2 = new Student("Revan", "Kovu", "rev@gmail.com");
			Student student3 = new Student("Reva", "Kov", "rev@gmail.com");
			Student student4 = new Student("Rev", "Ko", "rev@gmail.com");

			session.beginTransaction();

			session.save(student1);
			session.save(student2);
			session.save(student3);  
			session.save(student4);

			session.getTransaction().commit();

		} finally {
			factory.close();
		}

	}

}
