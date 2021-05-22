package com.senla.povargo.hotel.dto;

import com.senla.povargo.hotel.enums.Status;

public class RoomDTO {
    private final int number;
    private final double price;
    private final Status status;
    private final ClientDTO client;

    public RoomDTO(int number, double price, Status status, ClientDTO client) {
        this.number = number;
        this.price = price;
        this.status = status;
        this.client = client;
    }
    public RoomDTO(int number, double price, Status status) {
        this.number = number;
        this.price = price;
        this.status = status;
        this.client = new ClientDTO("");
    }

    @Override
    public String toString() {
        return "RoomDTO{" +
                "number=" + number +
                ", price=" + price +
                ", status=" + status +
                ", client=" + client.getName() +
                '}';
    }

    public int getNumber() {
        return number;
    }

    public double getPrice() {
        return price;
    }

    public Status getStatus() {
        return status;
    }

    public ClientDTO getClient() {
        return client;
    }
}
