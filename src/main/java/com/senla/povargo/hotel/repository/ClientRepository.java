package com.senla.povargo.hotel.repository;

import com.senla.povargo.hotel.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
