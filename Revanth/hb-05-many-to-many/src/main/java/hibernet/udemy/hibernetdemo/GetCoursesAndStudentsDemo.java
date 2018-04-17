package hibernet.udemy.hibernetdemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernet.udemy.entity.Course;
import hibernet.udemy.entity.Instructor;
import hibernet.udemy.entity.InstructorDetail;
import hibernet.udemy.entity.Review;
import hibernet.udemy.entity.Student;

public class GetCoursesAndStudentsDemo {
	public static void main(String args[]) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Student.class)
				.addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			Student student1 = session.load(Student.class, 1);
			System.out.println("Student1: " + student1);

			System.out.println("Courses: " + student1.getCourses());

			session.getTransaction().commit();
			System.out.println("Done!");

		} finally {
			session.close();
			factory.close();
		}
	}

}
