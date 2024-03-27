package org.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "firstName")
    private String fname;
    @Column(name = "lastName")
    private String lname;

    @Column(name = "email")
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ssn_id")
    private SSN personSSNDetails;

    public int getId() {
        return id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public SSN getPersonSSNDetails() {
        return personSSNDetails;
    }

    public void setPersonSSNDetails(SSN personSSNDetails) {
        this.personSSNDetails = personSSNDetails;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id is : " + id +
                ", fname is : '" + fname + '\'' +
                ", lname is : '" + lname + '\'' +
                ", email is : '" + email + '\'' +
                ", personSSNDetails is : " + (personSSNDetails != null ? personSSNDetails.getId() : "null") +
                '}';
    }
}