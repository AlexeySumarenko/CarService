package org.CarService.dto;

import lombok.Data;

@Data
public class SparePartDto {
    private int idSparePart;
    private String sparePartName;
    private Double price;
    private int quantity;
    private int idProducer;

}