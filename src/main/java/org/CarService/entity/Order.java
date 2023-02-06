package org.CarService.entity;

import lombok.Data;

@Data
public class Order {
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
