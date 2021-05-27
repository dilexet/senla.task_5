package com.senla.povargo.hotel.dto;

public class ClientDTO {
    private String name;

    public ClientDTO(String name) {
        this.name = name;
    }

    public ClientDTO() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
