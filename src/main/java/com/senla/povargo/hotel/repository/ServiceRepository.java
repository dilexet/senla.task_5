package com.senla.povargo.hotel.repository;

import com.senla.povargo.hotel.entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service, Long> {
    Service findByServiceName(String name);
}
