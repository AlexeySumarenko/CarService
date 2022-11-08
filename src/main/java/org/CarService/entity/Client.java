package org.CarService.entity;

import lombok.Data;

@Data
public class Client {
    private int id_client;
    private String full_name;
    private String user_name;
    private String password;
    private String gender;
    private String phone;
}
