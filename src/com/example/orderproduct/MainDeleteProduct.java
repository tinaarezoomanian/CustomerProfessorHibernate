package com.example.orderproduct;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.Scanner;

public class MainDeleteProduct {
    public static void main(String[] args) {
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        try (Session session = sf.openSession();
             Scanner in = new Scanner(System.in)) {
            System.out.print("Product ID to delete: ");
            int id = in.nextInt();
            session.beginTransaction();
            Product p = session.get(Product.class, id);
            if (p != null) {
                session.delete(p);
                System.out.println("Deleted Product ID=" + id);
            } else {
                System.out.println("Not found: " + id);
            }
            session.getTransaction().commit();
        }
        sf.close();
    }
}
