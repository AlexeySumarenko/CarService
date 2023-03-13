package org.CarService.service;

import org.CarService.dto.ServiceDto;
import org.CarService.mapper.ServiceMapper;
import org.CarService.mapper.ServiceMapperImpl;
import org.CarService.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceService {
    @Autowired
    public ServiceRepository serviceRepository;

    private ServiceMapper serviceMapper = new ServiceMapperImpl();

    public List<org.CarService.entity.Service> findAllServices() {
        return serviceRepository.findAll();
    }

    public String deleteService(int id) {
        return serviceRepository.deleteServiceById(id);
    }

    public String saveService(ServiceDto serviceDto){
        serviceRepository.saveService(serviceMapper.ServiceDtoToService(serviceDto));
        return "Service saved successfully";
    }
    public org.CarService.entity.Service updateService(int id, ServiceDto serviceDto){
        return serviceRepository.updateService(id, serviceMapper.ServiceDtoToService(serviceDto));
    }

    public org.CarService.entity.Service findServiceById(int id){
        return serviceRepository.findById(id);
    }
    public int getPageCount(int quantity){
        int Count = serviceRepository.getCount();
        return (int) Math.ceil((double) Count/quantity);
    }
    public int getCount(){
        return serviceRepository.getCount();
    }
}
