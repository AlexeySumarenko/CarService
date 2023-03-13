package org.CarService.config;

import lombok.Data;

import java.util.List;
@Data
public class PagedResponse<E> {
    int pageCount;
    int quantity;
    int pageNumber;
    int totalRows;
    List<E> cars;
}
