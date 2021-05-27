package com.senla.povargo.hotel.controller;

import com.senla.povargo.hotel.dto.ClientDTO;
import com.senla.povargo.hotel.dto.RoomDTO;
import com.senla.povargo.hotel.service.RoomManagement;
import com.senla.povargo.hotel.tools.Converter;
import com.senla.povargo.hotel.tools.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/room")
public class RoomController {
    private static final Logger logger = LoggerFactory.getLogger(RoomController.class.getName());

    private static final String SUCCESS = "OK";
    private static final String DEFAULT_SORT = "id";
    private static final String EMPTY = "";
    @Autowired
    RoomManagement roomManagement;

    @PostMapping("/add")
    public ResponseEntity<Response> addRoom(@RequestBody @Valid RoomDTO roomDTO) {
        var result = roomManagement.addRoom(Converter.convertToEntity(roomDTO));
        logger.info(result);
        return ResponseEntity.ok(new Response(5, SUCCESS, result));
    }

    @PostMapping("/accommodate")
    public ResponseEntity<Response> accommodateInRoom(@RequestBody @Valid ClientDTO clientDTO) {
        var result = roomManagement.accommodateInRoom(Converter.convertToEntity(clientDTO));
        logger.info(result);
        return ResponseEntity.ok(new Response(6, SUCCESS, result));
    }

    @PostMapping("/check-out")
    public ResponseEntity<Response> checkOutRoom(@RequestBody @Valid RoomDTO roomDTO) {
        var result = roomManagement.checkOutRoom(roomDTO.getNumber());
        logger.info(result);
        return ResponseEntity.ok(new Response(7, SUCCESS, result));
    }

    @PostMapping("/change-price")
    public ResponseEntity<Response> changePriceRoom(@RequestBody @Valid RoomDTO roomDTO) {
        var result = roomManagement.changePriceRoom(roomDTO.getNumber(), roomDTO.getPrice());
        logger.info(result);
        return ResponseEntity.ok(new Response(8, SUCCESS, result));
    }

    // http://localhost:8080/room/room-by-id?id=12
    @GetMapping("/room-by-id")
    public ResponseEntity<Response> getRoomById(@RequestParam("id") Long id) throws Exception {
        var room = roomManagement.getById(id);
        var result = Converter.convertToDTO(room);
        return ResponseEntity.ok(new Response(9, SUCCESS, result));
    }

    // http://localhost:8080/room/rooms?sort=id
    @GetMapping("/rooms")
    public ResponseEntity<Response> getRooms(@RequestParam("sort") String sort) throws Exception {
        if (sort == null || sort.equals(EMPTY)) {
            sort = DEFAULT_SORT;
        }
        var result = roomManagement.getRooms(Sort.by(sort)).stream().map(Converter::convertToDTO).collect(Collectors.toList());
        return ResponseEntity.ok(new Response(10, SUCCESS, result));
    }
}
