import com.mysql.cj.xdevapi.SessionFactory;
import org.hibernate.*;
import org.hibernate.cfg.*;

import javax.security.auth.login.Configuration;

public class HibernateDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration.configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        Employee e = new Employee();
        e.setName("Bibek");
        e.setSalary(50000);
        e.setPersist(e);
        session.getTransaction().commit();
        session.close();
        session = factory.openSession();
        Emp;loyee emp = session.get(Employee.class, 1);
        System.out.println("Employee Name: " + emp.getName());
        session.BeginTransaction();
        e1.setSalary(60000);
        session.Merge(e1);
        session.getTransaction().commit();
        session.close();
    }
}