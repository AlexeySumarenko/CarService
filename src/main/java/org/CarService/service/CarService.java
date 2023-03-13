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

    public List<Car> findAllCars(int offset, int quantity) {
        return carRepository.findAll(offset, quantity);
    }

    public String deleteCar(int id) {
       return carRepository.deleteCarById(id);
    }

    public String saveCar(CarDto carDto){
        carRepository.saveCar(carMapper.CarDtoToCar(carDto));
        return "car saved successfully";
    }
    public Car updateCar(int id, CarDto carDto){
        return carRepository.updateCar(id, carMapper.CarDtoToCar(carDto));
    }

    public Car findCarById(int id){
        return carRepository.findById(id);
    }

    public int getPageCount(int quantity){
        int Count = carRepository.getCount();
        return (int) Math.ceil((double) Count/quantity);
    }
    public int getCount(){
        return carRepository.getCount();
    }

}


