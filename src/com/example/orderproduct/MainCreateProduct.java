package com.example.orderproduct;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.Scanner;

public class MainCreateProduct {
    public static void main(String[] args) {
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        try (Session session = sf.openSession();
             Scanner in = new Scanner(System.in)) {
            System.out.print("Product name: ");
            String name = in.nextLine();
            session.beginTransaction();
            Product p = new Product();
            p.setName(name);
            session.save(p);
            session.getTransaction().commit();
            System.out.println("Created Product ID=" + p.getId());
        }
        sf.close();
    }
}
