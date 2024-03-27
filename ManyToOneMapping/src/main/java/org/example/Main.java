package org.example;

import org.example.configurations.HibernateUtils;
import org.example.entity.Country;
import org.example.entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.*;

/**
 * Hello world!
 *
 */
public class Main
{
    public static void main( String[] args )
    {

        Person p1 = new Person();
        p1.setFname("Virat");
        p1.setLname("Kohli");
        p1.setEmail("virat.kohli@gmail.com");

        List<Country> list = new ArrayList<>();

        Country add1 = new Country();
        add1.setCountry("India");
        list.add(add1);

        Country add2 = new Country();
        add2.setCountry("Australia");
        list.add(add2);

        add1.setPerson(p1);
        add2.setPerson(p1);
        p1.setPersonCountry(list);

        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.persist(p1);

        session.getTransaction().commit();

        System.out.println("Printing from person -: ");
        Person savedPerson = session.get(Person.class, 1L);
        System.out.println(savedPerson);

        System.out.println("Printing from Country -: ");
        Country savedCountry1 = session.get(Country.class, 1L);
        System.out.println(savedCountry1);

        Country savedCountry2 = session.get(Country.class, 2L);
        System.out.println(savedCountry2);

        session.close();
    }
}