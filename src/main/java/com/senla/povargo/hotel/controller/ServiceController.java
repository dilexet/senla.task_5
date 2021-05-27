package com.senla.povargo.hotel.controller;

import com.senla.povargo.hotel.dto.ServiceDTO;
import com.senla.povargo.hotel.service.ServiceManagement;
import com.senla.povargo.hotel.tools.Converter;
import com.senla.povargo.hotel.tools.Logger;
import com.senla.povargo.hotel.tools.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/service")
public class ServiceController {
    private static final String SUCCESS = "OK";
    private static final String DEFAULT_SORT = "id";
    private static final String EMPTY = "";
    @Autowired
    ServiceManagement serviceManagement;

    @PostMapping("/add")
    public ResponseEntity<Response> addService(@RequestBody @Valid ServiceDTO serviceDTO) {
        var result = serviceManagement.addService(Converter.convertToEntity(serviceDTO));
        Logger.info(result);
        return ResponseEntity.ok(new Response(1, SUCCESS, result));
    }

    @PostMapping("/change-price")
    public ResponseEntity<Response> changePriceService(@RequestBody @Valid ServiceDTO serviceDTO) {
        var result = serviceManagement.changePriceService(serviceDTO.getServiceName(), serviceDTO.getPrice());
        Logger.info(result);
        return ResponseEntity.ok(new Response(2, SUCCESS, result));
    }

    // http://localhost:8080/service/service-by-id?id=12
    @GetMapping("/service-by-id")
    public ResponseEntity<Response> getServiceById(@RequestParam("id") Long id) throws Exception {
        var service = serviceManagement.getById(id);
        var result = Converter.convertToDTO(service);
        return ResponseEntity.ok(new Response(3, SUCCESS, result));
    }

    // http://localhost:8080/service/services?sort=id
    @GetMapping("/services")
    public ResponseEntity<Response> getServices(@RequestParam("sort") String sort) throws Exception {
        if (sort == null || sort.equals(EMPTY)) {
            sort = DEFAULT_SORT;
        }
        var result = serviceManagement.getServices(Sort.by(sort)).stream().map(Converter::convertToDTO).collect(Collectors.toList());
        return ResponseEntity.ok(new Response(4, SUCCESS, result));
    }
}