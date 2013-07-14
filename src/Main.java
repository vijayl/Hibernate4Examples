import com.mysql.jdbc.Driver;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.vijay.dto.UserDetails;

import java.util.Calendar;

public class Main {

    public static void main(String[] args) throws Exception{

        System.out.println(" Starting hibernate 1") ;

        UserDetails user = new UserDetails();

        user.setUserId(1);
        user.setUserName("First User");
        user.setAddress("Users Address");
        user.setDescription("A very good user");
        user.setJoinedDate(Calendar.getInstance().getTime());

        // Create a Session Factrory.
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        // Create session from the Session Factory
        Session session = sessionFactory.openSession();

        // Save model objects using session.
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();

        session.close();

        session = sessionFactory.openSession();
        session.beginTransaction();
        UserDetails user2 = (UserDetails)session.get(UserDetails.class, 1);
        System.out.println("The username is : " + user2.getUserName())   ;
        session.close();




        System.out.println("Completed !!!");
    }
}
