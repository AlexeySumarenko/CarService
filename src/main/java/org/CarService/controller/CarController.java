package org.CarService.controller;

import org.CarService.dto.CarDto;
import org.CarService.entity.*;
import org.CarService.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
@CrossOrigin("http://localhost:3000/")
public class CarController {
    @Autowired
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    public List<Car> getAllCars() {
        return this.carService.findAllCars();
    }

    @PostMapping("/cars")
    public String saveCar(@RequestBody CarDto carDto){
        return this.carService.saveCar(carDto);
    }
    @GetMapping("/cars/{id}")
    public Car findCar(@PathVariable int id){
        return this.carService.findCarById(id);
    }

    /*@DeleteMapping("/cars/{id}")
    public String deleteCar(int id){
        return this.carService.deleteCar(id);*/

}
