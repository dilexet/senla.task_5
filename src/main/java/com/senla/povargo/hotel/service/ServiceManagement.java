package com.senla.povargo.hotel.service;

import com.senla.povargo.hotel.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceManagement {
    @Autowired
    ServiceRepository serviceRepository;

    public List<com.senla.povargo.hotel.entity.Service> getServices(Sort sort) throws Exception {
        var services = serviceRepository.findAll(sort);
        if (services.isEmpty()) {
            throw new Exception("No services");
        }
        return services;
    }

    public String changePriceService(String serviceName, double newPrice) {
        var service = serviceRepository.findByServiceName(serviceName);
        if (service == null) {
            return "Service not found";
        } else {
            service.setPrice(newPrice);
            serviceRepository.save(service);
            return "The cost of the " + service.getServiceName() + " service has been changed to " + service.getPrice() + "$";
        }
    }

    public String addService(com.senla.povargo.hotel.entity.Service service) {
        var services = serviceRepository.findByServiceName(service.getServiceName());
        if (services != null) {
            return "A service with this name already exists";
        } else {
            serviceRepository.save(service);
            return "Service " + service.getServiceName() + " added successfully";
        }
    }

    public com.senla.povargo.hotel.entity.Service getById(Long id) throws Exception {
        var service = serviceRepository.findById(id).orElse(null);
        if (service == null) {
            throw new Exception("Service not found");
        }
        return service;
    }
}
