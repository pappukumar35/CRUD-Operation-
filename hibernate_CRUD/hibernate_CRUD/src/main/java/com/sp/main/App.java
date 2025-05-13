package com.sp.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.sp.main.entity.User;

public class App {
    public static void main(String[] args) {
        User user1 = new User();
        user1.setId(1);
        user1.setName("Pappu Kumar");
        user1.setEmail("pappu@gmail.com");
        user1.setPassword("pappu@123");
        user1.setCity("Chennai");

        // Create configuration object and load hibernate.cfg.xml
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml"); 

        // Build SessionFactory and open session
        SessionFactory sessionFactory = cfg.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.save(user1);
            transaction.commit();
            System.out.println("User saved successfully.");
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
