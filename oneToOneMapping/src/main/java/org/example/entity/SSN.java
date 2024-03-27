package org.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ssn")
public class SSN {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "ssnNumber")
    private String ssnNumber;

    @OneToOne(mappedBy = "personSSNDetails", cascade = CascadeType.ALL)
    private Person person;

    public int getId() {
        return id;
    }

    public String getSSNNumber() {
        return ssnNumber;
    }

    public void setSSNNumber(String ssnNumber) {
        this.ssnNumber = ssnNumber;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "SSN{" +
                "id is: " + id +
                ", ssnNumber is: '" + ssnNumber + '\'' +
                ", person is : " + (person != null ? person.getId() : "null") +
                '}';
    }
}