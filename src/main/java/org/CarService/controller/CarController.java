package org.CarService.controller;

import org.CarService.config.PagedResponse;
import org.CarService.dto.CarDto;
import org.CarService.entity.*;
import org.CarService.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
    public PagedResponse<Car> getAllCars(@RequestParam("pageNumber") Integer pageNumber, @RequestParam("quantity") Integer quantity) {
        int offset = (pageNumber - 1) * quantity;
        int pageCount = this.carService.getPageCount(quantity);
        List<Car> list = this.carService.findAllCars(offset,quantity);

        PagedResponse<Car> pagedResponse = new PagedResponse<>();
        pagedResponse.setPageNumber(pageNumber);
        pagedResponse.setPageCount(pageCount);
        pagedResponse.setCars(list);
        pagedResponse.setTotalRows(this.carService.getCount());
        if(List.of(3, 5, 10, 15, 20).contains(quantity)){
            pagedResponse.setQuantity(quantity);
        }else {
            pagedResponse.setQuantity(5);
        }
        return pagedResponse;
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
