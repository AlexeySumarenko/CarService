package org.CarService.service;

import org.CarService.dto.EmployeeDto;
import org.CarService.entity.Employee;
import org.CarService.mapper.EmployeeMapper;
import org.CarService.mapper.EmployeeMapperImpl;
import org.CarService.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    public EmployeeRepository employeeRepository;

    private EmployeeMapper employeeMapper = new EmployeeMapperImpl();

    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    public String deleteEmployee(int id) {
        return employeeRepository.deleteEmployeeById(id);
    }

    public String saveEmployee(EmployeeDto employeeDto){
        employeeRepository.saveEmployee(employeeMapper.EmployeeDtoToEmployee(employeeDto));
        return "Employee saved successfully";
    }
    public Employee updateEmployee(int id, EmployeeDto employeeDto){
        return employeeRepository.updateEmployee(id, employeeMapper.EmployeeDtoToEmployee(employeeDto));
    }

    public Employee findEmployeeById(int id){
        return employeeRepository.findById(id);
    }
    public int getPageCount(int quantity){
        int Count = employeeRepository.getCount();
        return (int) Math.ceil((double) Count/quantity);
    }
    public int getCount(){
        return employeeRepository.getCount();
    }
}
