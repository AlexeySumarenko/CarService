package org.CarService.service;

import org.CarService.entity.Employee;
import org.CarService.entity.Producer;
import org.CarService.repository.EmployeeRepository;
import org.CarService.repository.ProducerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProducerService {
    @Autowired
    public ProducerRepository producerRepository;

    public List<Producer> getProducers(){
        return producerRepository.findAll();}
}
