package com.senla.povargo.hotel.entity;

import javax.persistence.*;

@Entity
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String serviceName;
    private double price;

    public Service(String serviceName, double price) throws Exception {
        this.serviceName = serviceName;
        if (price < 0.0) {
            throw new Exception("incorrect price");
        }
        this.price = price;
    }

    public Service() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) throws Exception {
        if (price < 0.0) {
            throw new Exception("incorrect price");
        }
        this.price = price;
    }
}
