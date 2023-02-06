package org.CarService.controller;

import org.CarService.dto.EmployeeDto;
import org.CarService.entity.Employee;
import org.CarService.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("employees")
@CrossOrigin("http://localhost:3000")
public class EmployeeController {
    @Autowired
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping()
    public List<Employee> getAllEmployees() {
        return this.employeeService.findAllEmployees();
    }

    @PostMapping()
    public String saveEmployee(@RequestBody EmployeeDto employeeDto){
        return this.employeeService.saveEmployee(employeeDto);
    }
    @GetMapping("/{id}")
    public Employee findEmployee(@PathVariable int id){
        return this.employeeService.findEmployeeById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable int id){
        return this.employeeService.deleteEmployee(id);}

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable("id") int id, @RequestBody EmployeeDto employeeDto) {
        return this.employeeService.updateEmployee(id, employeeDto);
    }
}
