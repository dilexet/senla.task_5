package com.senla.povargo.hotel.tools;

import com.senla.povargo.hotel.dto.ClientDTO;
import com.senla.povargo.hotel.dto.RoomDTO;
import com.senla.povargo.hotel.dto.ServiceDTO;
import com.senla.povargo.hotel.entity.Client;
import com.senla.povargo.hotel.entity.Room;
import com.senla.povargo.hotel.entity.Service;

public class Converter {
    public static RoomDTO convertToDTO(Room room) {
        if (room.getClient() != null) {
            return new RoomDTO(room.getNumber(), room.getPrice(), room.getStatus(), convertToDTO(room.getClient()));
        }
        return new RoomDTO(room.getNumber(), room.getPrice(), room.getStatus());
    }

    public static ServiceDTO convertToDTO(Service service) {
        return new ServiceDTO(service.getServiceName(), service.getPrice());
    }

    public static ClientDTO convertToDTO(Client client) {
        return new ClientDTO(client.getName());
    }
}
