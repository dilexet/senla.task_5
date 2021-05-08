package com.senla.povargo.hotel.service;

import com.senla.povargo.hotel.entity.Client;
import com.senla.povargo.hotel.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import java.util.List;

@SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
@Service
@Configurable
public class ClientManagement {
    @Autowired
    ClientRepository clientRepository;

    public void addClient(Client client) {
        clientRepository.save(client);
    }

    public Client getById(Long id) {
        return clientRepository.findById(id).orElse(null);
    }

    public List<Client> getClients() {
        return clientRepository.findAll();
    }
}
