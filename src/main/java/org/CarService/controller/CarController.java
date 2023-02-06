package org.CarService.controller;

import org.CarService.dto.CarDto;
import org.CarService.entity.*;
import org.CarService.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cars")
@CrossOrigin("http://localhost:3000")
public class CarController {
    @Autowired
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping()
    public List<Car> getAllCars() {
        return this.carService.findAllCars();
    }

    @PostMapping()
    public String saveCar(@RequestBody CarDto carDto){
        return this.carService.saveCar(carDto);
    }
    @GetMapping("/{id}")
    public Car findCar(@PathVariable int id){
        return this.carService.findCarById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteCar(@PathVariable int id){
        return this.carService.deleteCar(id);}

    @PutMapping("/{id}")
    public Car updateCar(@PathVariable("id") int id, @RequestBody CarDto carDto) {
        return this.carService.updateCar(id, carDto);
    }

}
