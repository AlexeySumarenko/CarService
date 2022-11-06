package org.CarService.service;

import org.CarService.entity.Car;
import org.CarService.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService {
    @Autowired
    public CarRepository carRepository;

    public List<String> getCars(){
        return carRepository.findAll().stream().map(Car::getTitle).collect(Collectors.toList());
    }

}
