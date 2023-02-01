package org.CarService.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;


@Data
public class Car {
    private int idCar;
    private int idClient;
    private String carBrand;
    private String model;
    private String type;
    private int releaseYear;
}
