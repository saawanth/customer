package hibernet.udemy.hibernetdemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernet.udemy.entity.Course;
import hibernet.udemy.entity.Instructor;
import hibernet.udemy.entity.InstructorDetail;

public class CreateInstructorDemo {
	public static void main(String args[]) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			System.out.println("creating object.......");
			Instructor tempInstructor = new Instructor("revanth", "kovuri", "rev@gmail.com");
			InstructorDetail tempInstructorDetail = new InstructorDetail("youtube/revanth", "coding");
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			System.out.println("saving instructor: " + tempInstructor);
			session.save(tempInstructor);
			System.out.println("saving instructor: " + tempInstructor);
			session.getTransaction().commit();
			System.out.println("commit!");

		} finally {
			factory.close();
		}
	}

}
