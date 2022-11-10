package org.CarService.service;

import org.CarService.entity.Car;
import org.CarService.repository.CarRepository;
import org.CarService.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLDataException;
import java.util.List;

@Service
public class CarService {
    @Autowired
    public CarRepository carRepository;


    public List<Car> getCars() {
        return carRepository.findAll();
    }

}
