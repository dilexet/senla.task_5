package com.senla.povargo.hotel.dto;

import com.senla.povargo.hotel.enums.Status;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class RoomDTO {
    @Min(value = 1, message = "Room number should be greater than 0")
    @NotNull(message = "Room number can not be null")
    private int number;
    @Min(value = 1, message = "Room price should be greater than 0")
    @NotNull(message = "Room price can not be null")
    private double price;
    @NotNull(message = "Room status can not be null")
    private Status status = Status.FREE;
    private ClientDTO client;

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

    public RoomDTO(int number, double price) {
        this.number = number;
        this.price = price;
        this.client = new ClientDTO("");
    }

    public RoomDTO() {

    }


    @Override
    public String toString() {
        if (client != null) {
            return "RoomDTO{" +
                    "number=" + number +
                    ", price=" + price +
                    ", status=" + status +
                    ", client=" + client.getName() +
                    '}';
        }
        return "RoomDTO{" +
                "number=" + number +
                ", price=" + price +
                ", status=" + status +
                ", client= null}";
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
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

    public ClientDTO getClient() {
        return client;
    }

    public void setClient(ClientDTO client) {
        this.client = client;
    }
}
