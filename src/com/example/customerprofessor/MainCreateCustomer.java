package com.example.customerprofessor;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainCreateCustomer {
    public static void main(String[] args) {
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        try (Session session = sf.openSession()) {
            session.beginTransaction();

            Customer c = new Customer();
            c.setName("Alice Smith");
            c.setAddress("123 Main St");

            Professor p = new Professor();
            p.setOfficeNumber("B123");
            p.setResearchArea("Databases");

            c.setProfessor(p);
            session.save(c);

            session.getTransaction().commit();
            System.out.printf("Created Customer ID=%d, Professor ID=%d%n",
                              c.getId(), p.getId());
        }
        sf.close();
    }
}
