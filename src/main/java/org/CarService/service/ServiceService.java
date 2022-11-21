package org.CarService.service;

import org.CarService.entity.Employee;
import org.CarService.repository.EmployeeRepository;
import org.CarService.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceService {
    @Autowired
    public ServiceRepository serviceRepository;

    public List<org.CarService.entity.Service> getServices(){
        return serviceRepository.findAll();}
}
