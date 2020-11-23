package sk.itsovy.ganoczi.hibernate.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import sk.itsovy.ganoczi.hibernate.entity.Instructor;
import sk.itsovy.ganoczi.hibernate.entity.InstructorDetail;

public class DeleteDemo {

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

            int theId=1;
            Instructor tempInstructor=session.get(Instructor.class, theId);

            System.out.println("Found instructor: "+ tempInstructor);

            //delete instructor

            if (tempInstructor !=null) {

                System.out.println("Deleting: "+tempInstructor);

                //this will also detail object because of cascadetype.all
                session.delete(tempInstructor);
            }


            //commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {
            factory.close();
        }

    }
}
