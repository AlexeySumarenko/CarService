package org.CarService.dto;

import lombok.Data;

@Data
public class OrderDto {
    private int idOrder;
    private String dateOfReceiving;
    private String dateOfCompletion;
    private int idClient;
    private int idEmployee;
    private Double price;
    private String status;
    private int idCar;
    private int idService;
    private int idSparePart;
}
