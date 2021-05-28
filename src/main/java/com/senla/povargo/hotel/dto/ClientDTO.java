package com.senla.povargo.hotel.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class ClientDTO {
    @NotEmpty(message = "Client name is mandatory")
    @Size(min = 2, max = 30, message = "Client name should be between 2 and 30 characters")
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
