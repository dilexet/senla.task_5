package com.senla.povargo.hotel.entity;

import com.senla.povargo.hotel.enums.Status;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    @Min(value = 1, message = "Room number should be greater than 0")
    @NotNull(message = "Room number can not be null")
    private int number;

    @Min(value = 1, message = "Room price should be greater than 0")
    @NotNull(message = "Room price can not be null")
    private double price;

    @NotNull(message = "Room status can not be null")
    private Status status = Status.FREE;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id")
    private Client client;

    public Room(int number, double price) {
        this.number = number;
        this.price = price;
    }

    protected Room() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
