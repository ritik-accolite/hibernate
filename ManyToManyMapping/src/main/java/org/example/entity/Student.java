package org.example.entity;

import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String fName;
    private String lName;
    private String email;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Course> course;

    public int getId() {
        return id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Course> getCourse() {
        return course;
    }

    public void setCourse(List<Course> course) {
        this.course = course;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("Student{" +
                "id=" + id +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", email='" + email + '\'' +
                ", course=");

        for(Course m : getCourse()){
            res.append(m.getcourseName()).append(" ").append(m.getcourseId()).append(", ");
        }

        res.append("}");

        return res.toString();
    }
}