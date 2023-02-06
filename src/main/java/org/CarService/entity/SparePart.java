package org.CarService.entity;

import lombok.Data;

@Data
public class SparePart {
    private int idSparePart;
    private String sparePartName;
    private Double price;
    private int quantity;
    private int idProducer;

}
