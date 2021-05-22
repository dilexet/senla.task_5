package com.senla.povargo.hotel.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    @NotEmpty(message = "Client name is mandatory")
    @Size(min = 2, max = 30, message = "Client name should be between 2 and 30 characters")
    private String name;

    @OneToOne(mappedBy = "client", cascade = CascadeType.ALL)
    private Room room;

    public Client(String name) {
        this.name = name;
    }

    protected Client() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
