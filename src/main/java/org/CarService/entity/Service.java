package org.CarService.entity;

import lombok.Data;

@Data
public class Service {
    private int idService;
    private String serviceName;
    private Double price;
    private String guarantee;

}
