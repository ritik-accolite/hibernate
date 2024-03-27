package org.example;

import org.example.configurations.HibernateUtils;
import org.example.entity.Vehicle;
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
        p1.setFname("Ritik");
        p1.setLname("Kumar");
        p1.setEmail("ritik.kumar@accolitedigital.com");

        List<Vehicle> list = new ArrayList<>();

        Vehicle acc1 = new Vehicle();
        acc1.setVehicleNumber(8880);
        acc1.setVehicleType("SUV");
        acc1.setAmount(4500000.0);
        list.add(acc1);

        Vehicle acc2 = new Vehicle();
        acc2.setVehicleNumber(7616);
        acc1.setVehicleType("Hatchback");
        list.add(acc2);

        acc1.setPerson(p1);
        acc2.setPerson(p1);
        p1.setPersonVehicleDetails(list);

        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.persist(p1);

        session.getTransaction().commit();

        System.out.println("Printing from person -: ");
        Person savedPerson = session.get(Person.class, 1L);
        System.out.println(savedPerson);

        System.out.println("Printing from Vehicle -: ");
        Vehicle savedVehicle = session.get(Vehicle.class, 1L);
        System.out.println(savedVehicle);

        Vehicle savedVehicle2 = session.get(Vehicle.class, 2L);
        System.out.println(savedVehicle2);

        session.close();
    }
}