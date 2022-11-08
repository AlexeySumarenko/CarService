package org.CarService.entity;

import lombok.Data;

@Data
public class Employee {
    private int id_employee;
    private String full_name;
    private String job_position;
    private int age;
    private String phone;
    private String address;
}
