package com.senla.povargo.hotel.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ServiceDTO {
    @NotEmpty(message = "service.name.notNull.failed.msg")
    @Size(min = 2, max = 30, message = "service.name.outOfSize.failed.msg")
    public String serviceName;

    @Min(value = 0, message = "service.price.notMinValue.failed.msg")
    @NotNull(message = "service.price.notNull.failed.msg")
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
