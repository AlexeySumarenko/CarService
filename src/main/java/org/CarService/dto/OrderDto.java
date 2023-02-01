package org.CarService.dto;

import lombok.Data;

@Data
public class OrderDto {
    private int idOrder;
    private String dateOfReceiving;
    private String dateOfCompletion;
    private Double price;
    private String status;
}
