package com.senla.povargo.hotel.entity;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    @NotEmpty(message = "Service name is mandatory")
    @Size(min = 2, max = 30, message = "Service name should be between 2 and 30 characters")
    private String serviceName;

    @Min(value = 0, message = "Service price should be greater than 0")
    @NotNull(message = "Service price can not be null")
    private Double price;

    public Service(String serviceName, Double price) throws Exception {
        this.serviceName = serviceName;
        this.price = price;
    }

    protected Service() {

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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
