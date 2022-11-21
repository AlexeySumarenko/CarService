package org.CarService.service;

import org.CarService.entity.Employee;
import org.CarService.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    public EmployeeRepository employeeRepository;
    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }
}
