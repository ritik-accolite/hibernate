package org.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "vehicle")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private long vehicleNumber;
    private String vehicleType;
    private Double amount;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    private Person person;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(long vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", vehicleNumber=" + vehicleNumber +
                ", vehicleType='" + vehicleType + '\'' +
                ", amount=" + amount +
                ", person=" + person.getId() +
                '}';
    }
}