package org.CarService.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
public class Car {
    private String title;
    private int id_car;
    private int id_client;
    private String car_brand;
    private String model;
    private String type;
    private int release_year;


}
