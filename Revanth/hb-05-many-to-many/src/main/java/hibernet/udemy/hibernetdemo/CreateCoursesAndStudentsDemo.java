package hibernet.udemy.hibernetdemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernet.udemy.entity.Course;
import hibernet.udemy.entity.Instructor;
import hibernet.udemy.entity.InstructorDetail;
import hibernet.udemy.entity.Review;
import hibernet.udemy.entity.Student;

public class CreateCoursesAndStudentsDemo {
	public static void main(String args[]) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Student.class)
				.addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			Course tempCourse = new Course("How to Eat Grapes:");
			session.save(tempCourse);
			System.out.println("saved coursess");

			Student student1 = new Student("rEvanth", "kovur", "re@#mnjkcnj");
			Student student2 = new Student("rEv", "ko", "re@#mnjkcnj");

			tempCourse.addStudent(student1);
			tempCourse.addStudent(student2);

			session.save(student1);
			session.save(student2);

			System.out.println("saved students");

			session.getTransaction().commit();
			System.out.println("Done!");

		} finally {
			session.close();
			factory.close();
		}
	}

}
