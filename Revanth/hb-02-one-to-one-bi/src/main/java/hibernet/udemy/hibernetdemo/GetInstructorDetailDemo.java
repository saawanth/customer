package hibernet.udemy.hibernetdemo;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernet.udemy.entity.Instructor;
import hibernet.udemy.entity.InstructorDetail;

public class GetInstructorDetailDemo {
	public static void main(String args[]) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();

			InstructorDetail instructorDetail = session.get(InstructorDetail.class, 2);
			System.out.println(instructorDetail);

			System.out.println(instructorDetail.getInstructor());

			session.getTransaction().commit();
			System.out.println("commit!");

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		finally {
			session.close();
			factory.close();
		}
	}

}
