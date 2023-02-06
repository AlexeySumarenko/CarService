package org.CarService.controller;

import org.CarService.dto.CarDto;
import org.CarService.dto.ClientDto;
import org.CarService.entity.Car;
import org.CarService.entity.Client;
import org.CarService.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clients")
@CrossOrigin("http://localhost:3000")
public class ClientController {
    @Autowired
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping()
    public List<Client> getAllClients() {
        return this.clientService.findAllClients();
    }

    @PostMapping()
    public String saveClient(@RequestBody ClientDto clientDto){
        return this.clientService.saveClient(clientDto);
    }
    @GetMapping("/{id}")
    public Client findClient(@PathVariable int id){
        return this.clientService.findClientById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteClient(@PathVariable int id){
        return this.clientService.deleteClient(id);}

    @PutMapping("/{id}")
    public Client updateClient(@PathVariable("id") int id, @RequestBody ClientDto clientDto) {
        return this.clientService.updateDtoClient(id, clientDto);
    }

}
