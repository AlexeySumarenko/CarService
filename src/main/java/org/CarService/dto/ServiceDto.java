package org.CarService.dto;

import lombok.Data;

@Data
public class ServiceDto {
    private int idService;
    private String serviceName;
    private Double price;
    private String guarantee;

}
