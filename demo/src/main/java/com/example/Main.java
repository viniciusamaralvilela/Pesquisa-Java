package com.example;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite seu nome");
        String name = sc.nextLine();
        System.out.print("Digite sua idade");
        int pass = sc.nextInt();
        Usuario u = new Usuario(name, pass);
        sc.close();

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.persist(u);

        tx.commit();
        session.close();

        System.out.println("Usuário salvo com sucesso!");
    }
}

