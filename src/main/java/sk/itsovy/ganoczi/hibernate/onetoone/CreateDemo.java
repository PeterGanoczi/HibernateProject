package sk.itsovy.ganoczi.hibernate.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import sk.itsovy.ganoczi.hibernate.entity.Instructor;
import sk.itsovy.ganoczi.hibernate.entity.InstructorDetail;
public class CreateDemo {


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
            //create the objects
            Instructor tempInstructor=
                    new Instructor("Chad", "Darby", "darby@gmail.com");

            InstructorDetail tempInstructorDetail=
                    new InstructorDetail("www.youtube.com/luv2code", "Codiiing");

            //associate the objects
            tempInstructor.setInstructorDetail(tempInstructorDetail);

            //start a transaction
            session.beginTransaction();

            //save the instructor

            // this will also save the detail object because of CascadeType.ALL
            System.out.println("Saving instructor: " +tempInstructor);
            session.save(tempInstructor);


            //commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {
            factory.close();
        }

    }
}
