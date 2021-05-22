package com.senla.povargo.hotel.controller;

import com.senla.povargo.hotel.entity.Service;
import com.senla.povargo.hotel.service.ServiceManagement;
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
@RequestMapping("service")
public class ServiceController {
    private static final String SUCCESS = "OK";
    private static final String DEFAULT_SORT = "id";
    private static final String EMPTY = "";
    @Autowired
    ServiceManagement serviceManagement;

    @PostMapping("add")
    public ResponseEntity<Response> addService(@RequestBody @Valid Service service,
                                               BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            var errors = BindingError.getErrors(bindingResult);
            throw new Exception(errors);
        }
        var result = serviceManagement.addService(service);
        Logger.info(result);
        return ResponseEntity.ok(new Response(1, SUCCESS, result));
    }

    @PostMapping("changePrice")
    public ResponseEntity<Response> changePriceService(@RequestBody @Valid Service service,
                                                       BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            var errors = BindingError.getErrors(bindingResult);
            throw new Exception(errors);
        }
        var result = serviceManagement.changePriceService(service.getServiceName(), service.getPrice());
        Logger.info(result);
        return ResponseEntity.ok(new Response(2, SUCCESS, result));
    }

    @GetMapping("getById/{id}")
    public ResponseEntity<Response> getServiceById(@PathVariable Long id) throws Exception {
        var service = serviceManagement.getById(id);
        var result = Converter.convertToDTO(service);
        return ResponseEntity.ok(new Response(3, SUCCESS, result));
    }

    @GetMapping("getServices/{sort}")
    public ResponseEntity<Response> getServices(@PathVariable String sort) throws Exception {
        if (sort == null || sort.equals(EMPTY)) {
            sort = DEFAULT_SORT;
        }
        var result = serviceManagement.getServices(Sort.by(sort)).stream().map(Converter::convertToDTO).collect(Collectors.toList());
        return ResponseEntity.ok(new Response(4, SUCCESS, result));
    }
}