package org.CarService.dto;

import lombok.Data;

@Data
public class SparePartDto {
    private int idSparePart;
    private String name;
    private Double price;
    private int quantity;

}