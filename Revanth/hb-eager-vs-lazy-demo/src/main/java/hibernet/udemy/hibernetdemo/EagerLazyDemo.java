package hibernet.udemy.hibernetdemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernet.udemy.entity.Course;
import hibernet.udemy.entity.Instructor;
import hibernet.udemy.entity.InstructorDetail;

public class EagerLazyDemo {
	public static void main(String args[]) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			Instructor instructor = session.get(Instructor.class, 1);
			System.out.println("Instructor: " + instructor);

			session.getTransaction().commit();
			session.close();
			System.out.println(instructor.getCourses());
			System.out.println("Done!");

		} finally {
			factory.close();
		}
	}

}
