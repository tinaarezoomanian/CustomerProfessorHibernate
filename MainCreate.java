package com.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainCreate {
    public static void main(String[] args) {
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        try (Session session = sf.openSession()) {
            session.beginTransaction();

            Customer c = new Customer();
            c.setName("Dr. Alice");
            c.setAddress("1 University Way");

            Professor p = new Professor();
            p.setOfficeNumber("B123");
            p.setResearchArea("Algorithms");

            c.setProfessor(p);       // link them
            session.save(c);         // cascades to Professor

            session.getTransaction().commit();
            System.out.printf("Inserted Customer ID=%d, Professor ID=%d%n",
                              c.getId(), p.getId());
        }
        sf.close();
    }
}
