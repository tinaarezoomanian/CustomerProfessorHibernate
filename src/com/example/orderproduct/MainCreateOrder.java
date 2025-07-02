package com.example.orderproduct;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.Date;
import java.util.Scanner;

public class MainCreateOrder {
    public static void main(String[] args) {
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        try (Session session = sf.openSession();
             Scanner in = new Scanner(System.in)) {

            System.out.print("Product IDs (comma-sep): ");
            String line = in.nextLine();

            session.beginTransaction();
            Order o = new Order();
            o.setOrderDate(new Date());

            for (String tok : line.split(",")) {
                int pid = Integer.parseInt(tok.trim());
                Product p = session.get(Product.class, pid);
                if (p != null) o.addProduct(p);
                else System.out.println("No Product ID=" + pid);
            }

            session.save(o);
            session.getTransaction().commit();
            System.out.println("Created Order ID=" + o.getId());
        }
        sf.close();
    }
}
