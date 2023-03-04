package org.CarService.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class OrderDto {
    private int idOrder;
    private Date dateOfReceiving;
    private Date dateOfCompletion;
    private int idClient;
    private int idEmployee;
    private Double price;
    private String status;
    private int idCar;
    private int idService;
    private int idSparePart;
}
