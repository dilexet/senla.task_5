package com.senla.povargo.hotel.controller;

import com.senla.povargo.hotel.entity.Client;
import com.senla.povargo.hotel.entity.Room;
import com.senla.povargo.hotel.service.RoomManagement;
import com.senla.povargo.hotel.tools.BindingError;
import com.senla.povargo.hotel.tools.Converter;
import com.senla.povargo.hotel.tools.Logger;
import com.senla.povargo.hotel.tools.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.stream.Collectors;

@RestController
@RequestMapping("room")
public class RoomController {
    private static final String SUCCESS = "OK";
    private static final String DEFAULT_SORT = "id";
    private static final String EMPTY = "";
    @Autowired
    RoomManagement roomManagement;

    @PostMapping("add")
    public ResponseEntity<Response> addRoom(@RequestBody @Valid Room room,
                                            BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            var errors = BindingError.getErrors(bindingResult);
            throw new Exception(errors);
        }
        var result = roomManagement.addRoom(room);
        Logger.info(result);
        return ResponseEntity.ok(new Response(5, SUCCESS, result));
    }

    @PostMapping("accommodate")
    public ResponseEntity<Response> accommodateInRoom(@RequestBody @Valid Client client,
                                                      BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            var errors = BindingError.getErrors(bindingResult);
            throw new Exception(errors);
        }
        var result = roomManagement.accommodateInRoom(client);
        Logger.info(result);
        return ResponseEntity.ok(new Response(6, SUCCESS, result));
    }

    @PostMapping("checkOut")
    public ResponseEntity<Response> checkOutRoom(@RequestBody @Valid Room room,
                                                 BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            var errors = BindingError.getErrors(bindingResult);
            throw new Exception(errors);
        }
        var result = roomManagement.checkOutRoom(room.getNumber());
        Logger.info(result);
        return ResponseEntity.ok(new Response(7, SUCCESS, result));
    }

    @PostMapping("changePrice")
    public ResponseEntity<Response> changePriceRoom(@RequestBody @Valid Room room,
                                                    BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            var errors = BindingError.getErrors(bindingResult);
            throw new Exception(errors);
        }
        var result = roomManagement.changePriceRoom(room.getNumber(), room.getPrice());
        Logger.info(result);
        return ResponseEntity.ok(new Response(8, SUCCESS, result));
    }

    @GetMapping("getById/{id}")
    public ResponseEntity<Response> getRoomById(@PathVariable Long id) throws Exception {
        var room = roomManagement.getById(id);
        var result = Converter.convertToDTO(room);
        return ResponseEntity.ok(new Response(9, SUCCESS, result));
    }

    @GetMapping("getRooms/{sort}")
    public ResponseEntity<Response> getRooms(@PathVariable String sort) throws Exception {
        if (sort == null || sort.equals(EMPTY)) {
            sort = DEFAULT_SORT;
        }
        var result = roomManagement.getRooms(Sort.by(sort)).stream().map(Converter::convertToDTO).collect(Collectors.toList());
        return ResponseEntity.ok(new Response(10, SUCCESS, result));
    }
}
