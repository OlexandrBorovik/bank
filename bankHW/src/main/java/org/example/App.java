package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
    static EntityManagerFactory emf;
    static EntityManager em;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {

        emf = Persistence.createEntityManagerFactory("bank");
        em = emf.createEntityManager();



            while (true) {
                System.out.println("1: add client");
                System.out.println("2: Exchange rates");
                System.out.println("3: transfer between accounts");
                System.out.println("4: add transaction ");
                System.out.println("5: view  state of an account");
                System.out.print("-> ");

                String s = sc.nextLine();
                switch (s) {
                    case "1":
                        addClient(sc);
                        break;
                    case "2":
                        addTransaction(sc);
                        break;
                    case "3":
                        addTransaction(sc);
                        break;
                    case "4":
                       addTransaction(sc);
                        break;
                    case "5":
                        addTransaction(sc);
                        break;
                    default:
                        System.out.println("++++++++");
                        return;
                }
            }
        } finally {
            System.out.println("++++++++56565656");
            sc.close();
            em.close();
            emf.close();

        }
    }

    private static void addTransaction(Scanner sc) {
        System.out.println("Enter clients id:");
        long cd = sc.nextLong();

        Query query = em.createQuery(" FROM Clients client WHERE client.id=:idClient");
        query.setParameter("idClient", cd);
        Clients clientsSelect = (Clients) query.getSingleResult();
        System.out.println(clientsSelect.getAge());

        long id = clientsSelect.getId()+1 ;

        Invoice invRes = em.getReference(Invoice.class, id);
        System.out.println(invRes.getUsd());


        System.out.println("Enter sum 00.00:");
        Integer su = sc.nextInt();

            System.out.println("Select valute:");
            System.out.println("1: USD");
            System.out.println("2: EURO");
            System.out.println("3: UAH");

                        em.getTransaction().begin();
                        invRes.setUsd(invRes.getUsd() + su);
                        invRes.setEuro(0);
                        invRes.setUah(0);
                        if (invRes.getUsd() < 0) {
                            System.out.println("You dont have enough money!");
                            em.getTransaction().rollback();
                        } else {
                            em.persist(invRes);
                            System.out.println(invRes.getUsd());
                            em.getTransaction().commit();

                        }

        }



    public static void addClient(Scanner sc) {

        System.out.println("Enter name:");
        String name = sc.nextLine();
        System.out.println("Enter lastname:");
        String lastName = sc.nextLine();
        System.out.println("Enter age:");
        String age = sc.nextLine();
        int ageSave = Integer.parseInt(age);
        em.getTransaction().begin();

        try {
            Clients client = new Clients(name, lastName, ageSave);
            Invoice invoice = new Invoice(0,0,0);
            em.persist(client);
            em.persist(invoice);
            em.getTransaction().commit();

        } catch (Exception ex) {
            em.getTransaction().rollback();
        }
        Query query = em.createQuery(
                "SELECT clients  FROM Clients clients", Clients.class);
        List<Clients> list = (List<Clients>) query.getResultList();

        for (Clients c : list)
            System.out.println(c);
        Query querye = em.createQuery(
                "SELECT invoice  FROM Invoice invoice", Invoice.class);
        List<Invoice> lister = (List<Invoice>) querye.getResultList();

        for (Invoice rt : lister)
            System.out.println(rt);



    }

    }




