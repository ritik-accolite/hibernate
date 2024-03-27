package org.example;

import org.example.configurations.HibernateUtils;
import org.example.entity.SSN;
import org.example.entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Hello world!
 *
 */
public class Main
{
    public static void main( String[] args )
    {

        Person p1 = new Person();
        p1.setFname("Ritik");
        p1.setLname("Kumar");
        p1.setEmail("ritik.kumar@accolitedigital.com");

        SSN a1 = new SSN();
        a1.setSSNNumber("9999193330");

        a1.setPerson(p1);
        p1.setPersonSSNDetails(a1);

        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.persist(p1);

        session.getTransaction().commit();

        System.out.println("Person class  -: ");
        Person savedPerson = session.get(Person.class, 1);
        System.out.println(savedPerson);

        System.out.println("SSN class -: ");
        SSN savedSSN = session.get(SSN.class, 1);
        System.out.println(savedSSN);

        session.close();
    }
}