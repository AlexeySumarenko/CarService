package org.CarService.repository.Mapper;

import org.CarService.entity.Client;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientMapper implements RowMapper<Client> {
    @Override
    public Client mapRow(ResultSet rs, int rowNum) throws SQLException {
        Client client = new Client();
        client.setIdClient(rs.getInt("id_client"));
        client.setFullName(rs.getString("full_name"));
        client.setUserName(rs.getString("user_name"));
        client.setPassword(rs.getString("password"));
        client.setGender(rs.getString("gender"));
        client.setPhone(rs.getString("phone"));
        return client;
    }
}
