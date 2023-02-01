package org.CarService.service;

import org.CarService.dto.CarDto;
import org.CarService.mapper.CarMapper;
import org.CarService.entity.Car;
import org.CarService.mapper.CarMapperImpl;
import org.CarService.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;

    private CarMapper carMapper = new CarMapperImpl();

    public List<Car> findAllCars() {
        return carRepository.findAll();
    }

    public String deleteCar(int id) {
       return carRepository.deleteCarById(id);
    }

    public String saveCar(CarDto car){
        carRepository.saveCar(carMapper.CarDtoToCar(car));
        return "car saved successfully";
    }

    public Car findCarById(int i){
        return carRepository.findById(i);
    }
}


