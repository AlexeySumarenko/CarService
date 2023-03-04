package org.CarService.entity;

import lombok.Data;

import java.sql.Date;

@Data
public class Order {
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
