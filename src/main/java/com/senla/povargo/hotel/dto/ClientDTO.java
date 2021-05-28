package com.senla.povargo.hotel.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class ClientDTO {
    @NotEmpty(message = "client.name.notNull.failed.msg")
    @Size(min = 2, max = 30, message = "client.name.outOfSize.failed.msg")
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
