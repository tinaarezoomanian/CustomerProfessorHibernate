package com.example.orderproduct;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.Scanner;

public class MainDeleteOrder {
    public static void main(String[] args) {
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        try (Session session = sf.openSession();
             Scanner in = new Scanner(System.in)) {
            System.out.print("Order ID to delete: ");
            int id = in.nextInt();
            session.beginTransaction();
            Order o = session.get(Order.class, id);
            if (o != null) {
                session.delete(o);
                System.out.println("Deleted Order ID=" + id);
            } else {
                System.out.println("Not found: " + id);
            }
            session.getTransaction().commit();
        }
        sf.close();
    }
}
