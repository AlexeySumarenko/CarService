package org.CarService.dto;

import lombok.Data;

@Data
public class ServiceDto {
    private int id_service;
    private String service_name;
    private Double price;
    private String guarantee;

}
