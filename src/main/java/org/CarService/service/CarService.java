package org.CarService.service;

import org.CarService.entity.Car;
import org.CarService.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    @Autowired
    public CarRepository carRepository;


    public List<Car> findAllCars() {
        return carRepository.findAll();
    }

    public String deleteCar(int id) {
       return carRepository.deleteCarById(id);
    }

    public String saveCar(Car car){
        carRepository.saveCar(car);
        return "car saved successfully";
    }

    public Car findCar(int i){
        return carRepository.findById(i);
    }
}


