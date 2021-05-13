package com.senla.povargo.hotel.controller;

import com.senla.povargo.hotel.entity.Client;
import com.senla.povargo.hotel.entity.Room;
import com.senla.povargo.hotel.service.ClientManagement;
import com.senla.povargo.hotel.service.RoomManagement;
import com.senla.povargo.hotel.tools.Converter;
import com.senla.povargo.hotel.tools.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("room")
public class RoomController {
    @Autowired
    RoomManagement roomManagement;

    @Autowired
    ClientManagement clientManagement;

    @PostMapping("add")
    public ResponseEntity<String> addRoom(@RequestBody Room room) {
        var result = roomManagement.addRoom(room);
        Logger.Info(result);
        return ResponseEntity.ok(result);
    }

    @PostMapping("accommodate")
    public ResponseEntity<String> accommodateInRoom(@RequestBody Client client) {
        var result = roomManagement.accommodateInRoom(client);
        Logger.Info(result);
        return ResponseEntity.ok(result);
    }

    @PostMapping("checkOut")
    public ResponseEntity<String> checkOutRoom(@RequestBody Room room) {
        var result = roomManagement.checkOutRoom(room.getNumber());
        Logger.Info(result);
        return ResponseEntity.ok(result);
    }

    @PostMapping("changePrice")
    public ResponseEntity<String> changePriceRoom(@RequestBody Room room) {
        var result = roomManagement.changePriceRoom(room.getNumber(), room.getPrice());
        Logger.Info(result);
        return ResponseEntity.ok(result);
    }

    @GetMapping("getById/{id}")
    public ResponseEntity<String> getRoomById(@PathVariable Long id) throws Exception {
        var room = roomManagement.getById(id);
        if (room.getClient() != null) {
            var client = clientManagement.getById(room.getClient().getId());
            return ResponseEntity.ok(Converter.convertToDTO(room, client).toString());
        }
        return ResponseEntity.ok(Converter.convertToDTO(room).toString());
    }

    @GetMapping("getRooms/{sort}")
    public List<Room> getRooms(@PathVariable String sort) {
        // TODO: нужно ли конвертить в list<dto>
        if (sort == null || sort.equals("")) {
            sort = "id";
        }
        return roomManagement.getRooms(Sort.by(sort));
    }
}
