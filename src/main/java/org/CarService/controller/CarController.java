package org.CarService.controller;

import org.CarService.entity.*;
import org.CarService.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("car")
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
    public String saveCar(Car car){
        return this.carService.saveCar(car);
    }}

   // @GetMapping("/cars")
  /*  public Car findCar(int id){
        return this.carService.findCar(id);
    }*/
  /*  @DeleteMapping("/cars")
    public String deleteCar(int id){
        return this.carService.deleteCar(id);
    }
}*/
