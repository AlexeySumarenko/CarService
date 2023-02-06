package org.CarService.controller;

import org.CarService.dto.ServiceDto;
import org.CarService.entity.Service;
import org.CarService.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("services")
@CrossOrigin("http://localhost:3000")
public class ServiceController {
    @Autowired
    private final ServiceService serviceService;

    public ServiceController(ServiceService serviceService) {
        this.serviceService = serviceService;
    }

    @GetMapping()
    public List<Service> getAllServices() {
        return this.serviceService.findAllServices();
    }
    @PostMapping()
    public String saveService(@RequestBody ServiceDto serviceDto){
        return this.serviceService.saveService(serviceDto);
    }
    @GetMapping("/{id}")
    public Service findService(@PathVariable int id){
        return this.serviceService.findServiceById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteService(@PathVariable int id){
        return this.serviceService.deleteService(id);}

    @PutMapping("/{id}")
    public Service updateService(@PathVariable int id, @RequestBody ServiceDto serviceDto) {
        return this.serviceService.updateService(id, serviceDto);
    }
}
