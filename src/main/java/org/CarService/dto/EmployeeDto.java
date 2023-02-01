package org.CarService.dto;

import lombok.Data;

@Data
public class EmployeeDto {
    private int idEmployee;
    private String fullName;
    private String jobPosition;
    private int age;
    private String phone;
    private String address;
}
