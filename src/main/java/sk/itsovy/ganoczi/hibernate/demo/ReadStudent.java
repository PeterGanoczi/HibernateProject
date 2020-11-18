package sk.itsovy.ganoczi.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import sk.itsovy.ganoczi.hibernate.entity.Student;

public class ReadStudent {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try{
            System.out.println("Creating a new student...");
            Student tempStudent = new Student("Daffy", "Duck", "daffy@luv2code.com");
            session.beginTransaction();
            System.out.println("Saving student...");
            session.save(tempStudent);
            session.getTransaction().commit();
            System.out.println("Generated ID: " + tempStudent.getId());

            System.out.println("Retrieving student...");
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            System.out.println("Getting student with ID: " + tempStudent.getId());
            tempStudent = session.get(Student.class, tempStudent.getId());
            System.out.println("Retrieve complete: " + tempStudent);
            session.getTransaction().commit();

            System.out.println("Done!");
        }finally {
            sessionFactory.close();
        }
    }
}
