package org.example;

import org.example.configurations.HibernateUtils;
import org.example.entity.Student;
import org.example.entity.Course;
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

        Student stu1 = new Student();
        stu1.setfName("Ritik");
        stu1.setlName("Kumar");
        stu1.setEmail("ritik.kumar@accolitedigital.com");

        Student stu2 = new Student();
        stu2.setfName("Vinay");
        stu2.setlName("Bhati");
        stu2.setEmail("vinaybhati@gmail.com");

        List<Student> student = new ArrayList<>();
        student.add(stu1);
        student.add(stu2);

        Course m1 = new Course();
        m1.setcourseName("Hibernate");
        m1.setcourseId(100);

        Course m2 = new Course();
        m2.setcourseName("Spring");
        m2.setcourseId(105);

        List<Course> course = new ArrayList<>();
        course.add(m1);
        course.add(m2);

        stu1.setCourse(course);
        stu2.setCourse(course);

        m1.setStudent(student);
        m2.setStudent(student);

        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.persist(stu1);
        session.persist(stu2);
        session.persist(m1);
        session.persist(m2);

        session.getTransaction().commit();

        System.out.println("Printing from Student -: ");
        Student savedStudent1 = session.get(Student.class, 1L);
        System.out.println(savedStudent1);

        Student savedStudent2 = session.get(Student.class, 2L);
        System.out.println(savedStudent2);

        System.out.println("Printing from Course -: ");
        Course savedCourse1 = session.get(Course.class, 1L);
        System.out.println(savedCourse1);

        Course savedCourse2 = session.get(Course.class, 2L);
        System.out.println(savedCourse2);

        session.close();
    }
}