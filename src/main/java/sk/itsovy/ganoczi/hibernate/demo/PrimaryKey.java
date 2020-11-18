package sk.itsovy.ganoczi.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import sk.itsovy.ganoczi.hibernate.entity.Student;

public class PrimaryKey {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try{
            System.out.println("Creating a new students...");
            Student student1 = new Student("John", "Doe", "paul@luv2code.com");
            Student student2 = new Student("Mary", "Public", "mary@luv2code.com");
            Student student3 = new Student("Bonita", "Applebaum", "bonita@luv2code.com");

            session.beginTransaction();

            System.out.println("Saving students...");
            session.save(student1);
            session.save(student2);
            session.save(student3);
            session.getTransaction().commit();

            System.out.println("Done!");
        }finally {
            sessionFactory.close();
        }
    }
}
