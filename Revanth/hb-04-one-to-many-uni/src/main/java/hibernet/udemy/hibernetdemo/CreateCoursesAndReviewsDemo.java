package hibernet.udemy.hibernetdemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernet.udemy.entity.Course;
import hibernet.udemy.entity.Instructor;
import hibernet.udemy.entity.InstructorDetail;
import hibernet.udemy.entity.Review;

public class CreateCoursesAndReviewsDemo {
	public static void main(String args[]) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			Course tempCourse = new Course("How to Eat Grapes:");

			tempCourse.addReview(new Review("Excellent!!!"));
			tempCourse.addReview(new Review("MindKichaing!!!"));
			tempCourse.addReview(new Review("Marbulous"));
			System.out.println(tempCourse.getReviews());
			session.save(tempCourse);
			session.getTransaction().commit();
			System.out.println("Done!");

		} finally {
			session.close();
			factory.close();
		}
	}

}
