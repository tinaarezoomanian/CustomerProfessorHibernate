package com.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.Scanner;

public class MainDelete {
    public static void main(String[] args) {
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        try (Session session = sf.openSession();
             Scanner in = new Scanner(System.in)) {

            System.out.print("Enter Customer ID to delete: ");
            int id = in.nextInt();

            session.beginTransaction();
            Customer c = session.get(Customer.class, id);
            if (c != null) {
                session.delete(c);   // cascades delete to Professor
                System.out.println("Deleted Customer+Professor with ID=" + id);
            } else {
                System.out.println("No Customer found with ID=" + id);
            }
            session.getTransaction().commit();
        }
        sf.close();
    }
}
