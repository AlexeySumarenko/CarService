package org.CarService.controller;

import org.CarService.dto.ClientDto;
import org.CarService.entity.Client;
import org.CarService.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
@CrossOrigin("http://localhost:3000/")
public class ClientController {
    @Autowired
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/clients")
    public List<Client> getAllClients() {
        return this.clientService.findAllClients();
    }

    @PostMapping("/clients")
    public String saveClient(@RequestBody ClientDto clientDto){
        return this.clientService.saveClient(clientDto);
    }
    @GetMapping("/clients/{id}")
    public Client findClient(@PathVariable int id){
        return this.clientService.findClientById(id);
    }

    /*@DeleteMapping("/cars/{id}")
    public String deleteCar(int id){
        return this.carService.deleteCar(id);*/

}
