package org.CarService.entity;

import lombok.Data;

@Data
public class Service {
    private int id_service;
    private String service_name;
    private Double price;
    private String guarantee;

}
