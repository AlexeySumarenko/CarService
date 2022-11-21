package org.CarService.service;

import org.CarService.entity.Client;
import org.CarService.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    @Autowired
    public ClientRepository clientRepository;

    public List<Client> getClient() {
        return clientRepository.findAll();
    }
}
