package com.senla.povargo.hotel.dto;

public record ServiceDTO(String serviceName, double price) {

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
