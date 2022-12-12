package org.CarService.dto;

import lombok.Data;

@Data
public class CarDto {
    private int idCar;
    private int idClient;
    private String carBrand;
    private String model;
    private String type;
    private int releaseYear;
}
