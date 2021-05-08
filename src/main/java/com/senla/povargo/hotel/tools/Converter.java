package com.senla.povargo.hotel.tools;

import com.senla.povargo.hotel.dto.RoomDTO;
import com.senla.povargo.hotel.dto.ServiceDTO;
import com.senla.povargo.hotel.entity.Client;
import com.senla.povargo.hotel.entity.Room;
import com.senla.povargo.hotel.entity.Service;

public class Converter {

    public static RoomDTO convertToDTO(Room room, Client client) {
        return new RoomDTO(room.getNumber(), room.getPrice(), room.getStatus(), client);
    }

    public static RoomDTO convertToDTO(Room room) {
        return new RoomDTO(room.getNumber(), room.getPrice(), room.getStatus());
    }

    public static ServiceDTO convertToDTO(Service service) {
        return new ServiceDTO(service.getServiceName(), service.getPrice());
    }
}
