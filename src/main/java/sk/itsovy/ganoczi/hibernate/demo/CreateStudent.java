package sk.itsovy.ganoczi.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import sk.itsovy.ganoczi.hibernate.entity.Student;

public class CreateStudent {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try{
            System.out.println("Creating a new student...");
            Student student = new Student("Peter", "Ganoczi", "peto@petol.com");
            session.beginTransaction();

            System.out.println("Saving student...");
            session.save(student);

            session.getTransaction().commit();
            System.out.println("Done!");
        }finally {
            sessionFactory.close();
        }
    }
}
