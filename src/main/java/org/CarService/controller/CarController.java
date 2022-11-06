package org.CarService.controller;

import org.CarService.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class CarController {
    @Autowired
    private CarService carService;
    @GetMapping()
    public List<String> hello(){
        return this.carService.getCars();
    }

}
