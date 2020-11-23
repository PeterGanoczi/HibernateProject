package sk.itsovy.ganoczi.hibernate.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import sk.itsovy.ganoczi.hibernate.entity.Instructor;
import sk.itsovy.ganoczi.hibernate.entity.InstructorDetail;


public class DeleteInstructorDetail {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try{
            session.beginTransaction();

            int theId = 7;
            InstructorDetail instructorDetail = session.get(InstructorDetail.class, theId);
            System.out.println(instructorDetail.getInstructor().toString());

            instructorDetail.getInstructor().setInstructorDetail(null);

            session.delete(instructorDetail);
            session.getTransaction().commit();
            System.out.println("Done!");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
            sessionFactory.close();
        }
    }
}