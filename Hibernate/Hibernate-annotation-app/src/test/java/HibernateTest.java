import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.techlabs.entity.Student;

public class HibernateTest {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate-cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		System.out.println(factory.getClass());
		Session hbsession = null;
		try {
			hbsession = factory.getCurrentSession();
		} catch(HibernateException ex) {
			System.out.println("Session exception");
			ex.printStackTrace();
		}
		
		Session session = factory.openSession();
		System.out.println(hbsession.getClass());
		hbsession.beginTransaction();
		hbsession.save(new Student("Manoj", "B", "Male", "1001", 10));
		hbsession.save(new Student("Varshil", "Mehta", "Male", "1002", 9));
		hbsession.getTransaction().commit();
		//hbsession.close();
		
		Student student = null;
		hbsession = factory.openSession();
		hbsession.beginTransaction();
		student = (Student) hbsession.get(Student.class, 1);
		//System.out.println(student.getFirst_name());
		
		String hql = "from Student";
		Criteria criteria = hbsession.createCriteria(Student.class);
		List<Student> students = criteria.list();
		System.out.println(students.get(0).getFirst_name());
		
		for(Student student1: students) {
			System.out.println(student1.getFirst_name());
		}
	}
}
