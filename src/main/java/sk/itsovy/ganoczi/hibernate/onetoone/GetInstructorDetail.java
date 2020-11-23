package sk.itsovy.ganoczi.hibernate.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import sk.itsovy.ganoczi.hibernate.entity.Instructor;
import sk.itsovy.ganoczi.hibernate.entity.InstructorDetail;

public class GetInstructorDetail {

    public static void main(String[] args) {

        //create session factory

        SessionFactory factory=new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();
        //create session

        Session session=factory.getCurrentSession();


        try {

            //start a transaction
            session.beginTransaction();


            //get the instructor detail object
            int theId=2999;
            InstructorDetail tempInstructorDetail=session.get(InstructorDetail.class, theId);

            //print the instructor detail object
            System.out.println("tempInstructorDetail: "+tempInstructorDetail);

            //print the associated instructor
            System.out.println("the associated instructor: "+ tempInstructorDetail.getInstructor());


            //commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");

        }
        catch(Exception e) {
            e.printStackTrace();
        }
        finally {

            session.close();

            factory.close();
        }

    }
}
