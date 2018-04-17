package hibernet.udemy.hibernetdemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernet.udemy.entity.Course;
import hibernet.udemy.entity.Instructor;
import hibernet.udemy.entity.InstructorDetail;

public class CreateCoursesDemo {
	public static void main(String args[]) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			Instructor instructor = session.get(Instructor.class, 1);

			Course course1 = new Course("Guitar");
			Course course2 = new Course("Violin");
			instructor.add(course1);
			instructor.add(course2);

			session.save(course1);
			session.save(course2);

			session.getTransaction().commit();
			System.out.println("Done!");

		} finally {
			factory.close();
		}
	}

}
