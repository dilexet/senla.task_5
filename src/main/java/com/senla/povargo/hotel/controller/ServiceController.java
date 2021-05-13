package com.senla.povargo.hotel.controller;

import com.senla.povargo.hotel.entity.Service;
import com.senla.povargo.hotel.service.ServiceManagement;
import com.senla.povargo.hotel.tools.Converter;
import com.senla.povargo.hotel.tools.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("service")
public class ServiceController {
    @Autowired
    ServiceManagement serviceManagement;

    @PostMapping("add")
    public ResponseEntity<String> addService(@RequestBody Service service) {
        var result = serviceManagement.addService(service);
        Logger.Info(result);
        return ResponseEntity.ok(result);
    }

    @PostMapping("changePrice")
    public ResponseEntity<String> changePriceService(@RequestBody Service service) throws Exception {
        var result = serviceManagement.changePriceService(service.getServiceName(), service.getPrice());
        Logger.Info(result);
        return ResponseEntity.ok(result);
    }

    @GetMapping("getServices/{sort}")
    public List<Service> getServices(@PathVariable String sort) {
        if (sort == null || sort.equals("")) {
            sort = "id";
        }
        return serviceManagement.getServices(Sort.by(sort));
    }

    @GetMapping("getById/{id}")
    public ResponseEntity<String> getServiceDetails(@PathVariable Long id) {
        var service = serviceManagement.getById(id);
        return ResponseEntity.ok(Converter.convertToDTO(service).toString());
    }
}