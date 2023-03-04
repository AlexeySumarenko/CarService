package org.CarService.service;

import org.CarService.dto.ClientDto;
import org.CarService.entity.Client;
import org.CarService.mapper.ClientMapper;
import org.CarService.mapper.ClientMapperImpl;
import org.CarService.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    @Autowired
    public ClientRepository clientRepository;

    private ClientMapper clientMapper = new ClientMapperImpl();

    public List<Client> findAllClients() {
        return clientRepository.findAll();
    }

    public String deleteClient(int id) { return clientRepository.deleteClientById(id);}

    public String saveClient(Client client) {
        clientRepository.saveClient(client);
        return "client saved successfully";
    }

    public Client updateDtoClient(int id, ClientDto clientDto){
        return clientRepository.updateDtoClient(id, clientMapper.ClientDtoToClient(clientDto));
    }

    public Client findClientById(int id) {return clientRepository.findById(id);}

}
