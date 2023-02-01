package org.CarService.dto;

import lombok.Data;

@Data
public class ClientDto {
    private int idClient;
    private String fullName;
    private String userName;
    private String gender;
    private String phone;
}
