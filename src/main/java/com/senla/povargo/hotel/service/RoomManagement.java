package com.senla.povargo.hotel.service;

import com.senla.povargo.hotel.entity.Client;
import com.senla.povargo.hotel.entity.Room;
import com.senla.povargo.hotel.enums.Status;
import com.senla.povargo.hotel.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
@Service
@Configurable
public class RoomManagement {

    @Autowired
    RoomRepository roomRepository;

    public List<Room> getRooms(Sort sort) {
        return roomRepository.findAll(sort);
    }

    public String accommodateInRoom(Client client) {
        var room = roomRepository.findAll().stream().filter(r -> r.getStatus() == Status.FREE).findFirst();
        if (room.isEmpty()) {
            return "No free room";
        } else {
            room.get().setStatus(Status.BUSY);
            room.get().setClient(client);
            roomRepository.save(room.get());
            return "Room " + room.get().getNumber() + " is busy";
        }
    }

    public String checkOutRoom(int number) {
        var room = roomRepository.findAll().stream().filter(r -> r.getNumber() == number).findFirst();
        if (room.isEmpty()) {
            return "Room not found";
        } else {
            room.get().setStatus(Status.FREE);
            room.get().setClient(null);
            roomRepository.save(room.get());
            return "Client was evicted from room " + room.get().getNumber() + ", payable " + room.get().getPrice() + "$";
        }
    }

    public String changePriceRoom(int number, double newPrice) {
        var room = roomRepository.findByNumber(number);
        if (room == null) {
            return "Room not found";
        } else {
            room.setPrice(newPrice);
            roomRepository.save(room);
            return "The cost of room number " + room.getNumber() + " has been changed to " + room.getPrice() + "$";
        }
    }

    public String addRoom(Room room) {
        var rooms = roomRepository.findByNumber(room.getNumber());
        if (rooms != null) {
            return "A room with the same number already exists";
        } else {
            roomRepository.save(room);
            return "Room " + room.getNumber() + " added successfully";
        }
    }

    public Room getById(Long id) throws Exception {
        var room = roomRepository.findById(id).orElse(null);
        if (room == null) {
            throw new Exception("Room not found");
        }
        return room;
    }
}
