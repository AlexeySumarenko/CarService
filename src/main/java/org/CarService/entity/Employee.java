package org.CarService.entity;

import lombok.Data;

@Data
public class Employee {
    private int idEmployee;
    private String fullName;
    private String jobPosition;
    private int age;
    private String phone;
    private String address;
}
