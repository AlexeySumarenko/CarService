package org.CarService.repository;

import org.CarService.entity.Car;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarRepository {
     public List<Car> findAll(){
          return List.of(new Car("title1"), new Car("title2"));
     }

}
