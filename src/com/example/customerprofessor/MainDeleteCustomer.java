package com.example.customerprofessor;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.Scanner;

public class MainDeleteCustomer {
    public static void main(String[] args) {
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        try (Session session = sf.openSession();
             Scanner in = new Scanner(System.in)) {
            System.out.print("Customer ID to delete: ");
            int id = in.nextInt();
            session.beginTransaction();
            Customer c = session.get(Customer.class, id);
            if (c != null) {
                session.delete(c);
                System.out.println("Deleted Customer+Professor ID=" + id);
            } else {
                System.out.println("Not found: " + id);
            }
            session.getTransaction().commit();
        }
        sf.close();
    }
}
