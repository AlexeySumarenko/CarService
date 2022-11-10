package org.CarService.entity;

import lombok.Data;

@Data
public class Order {
    private int idOrder;
    private String dateOfReceiving;
    private String dateOfCompletion;
    private Double price;
    private String status;
}
