package com.senla.povargo.hotel.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ServiceDTO {
    @NotEmpty(message = "Service name is mandatory")
    @Size(min = 2, max = 30, message = "Service name should be between 2 and 30 characters")
    public String serviceName;

    @Min(value = 0, message = "Service price should be greater than 0")
    @NotNull(message = "Service price can not be null")
    public double price;

    public ServiceDTO(String serviceName, double price) {
        this.serviceName = serviceName;
        this.price = price;
    }

    public ServiceDTO() {

    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ServiceDTO{" +
                "serviceName='" + serviceName + '\'' +
                ", price=" + price +
                '}';
    }
}
