package org.CarService.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
public class Car {
    private String title;
    private int idCar;
    private int idClient;
    private String carBrand;
    private String model;
    private String type;
    private int releaseYear;


}
