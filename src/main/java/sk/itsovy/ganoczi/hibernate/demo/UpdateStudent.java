package sk.itsovy.ganoczi.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import sk.itsovy.ganoczi.hibernate.entity.Student;

public class UpdateStudent {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
        Session session;

        try{
            int studentId = 3;
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            Student student = session.get(Student.class, studentId);
            student.setFirstName("Peter");

            session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();

            session.getTransaction().commit();
            System.out.println("Done!");
        }finally {
            sessionFactory.close();
        }
    }
}
