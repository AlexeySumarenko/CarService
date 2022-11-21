package org.CarService.controller;

import org.CarService.entity.Client;
import org.CarService.service.CarService;
import org.CarService.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class ClientController {
    @Autowired
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/clients")
    public List<Client> getClients() {
        return this.clientService.getClient();
    }
}
