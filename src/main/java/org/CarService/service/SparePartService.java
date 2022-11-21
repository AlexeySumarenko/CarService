package org.CarService.service;

import org.CarService.entity.Employee;
import org.CarService.entity.SparePart;
import org.CarService.repository.EmployeeRepository;
import org.CarService.repository.SparePartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SparePartService {
    @Autowired
    public SparePartRepository sparePartRepository;

    public List<SparePart> getSpareParts(){
        return sparePartRepository.findAll();
}
}
