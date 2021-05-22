package com.senla.povargo.hotel.dto;

public class ServiceDTO {
    public String serviceName;
    public double price;

    public ServiceDTO(String serviceName, double price) {
        this.serviceName = serviceName;
        this.price = price;
    }

    public String getServiceName() {
        return serviceName;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "ServiceDTO{" +
                "serviceName='" + serviceName + '\'' +
                ", price=" + price +
                '}';
    }
}
