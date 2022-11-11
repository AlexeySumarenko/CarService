package org.CarService.repository;

import org.CarService.entity.Car;
import org.CarService.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ClientRepository {
    private final DataSource dataSource;

    public ClientRepository(@Autowired DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Client> findAll() {
        List<Client> clients = new ArrayList<>();
        String sqlQuery = "SELECT id_client, full_name, user_name, gender, phone FROM client";
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sqlQuery);
             ResultSet rs = ps.executeQuery()) {
            while(rs.next()) {
                var client = new Client();
                client.setIdClient(rs.getInt("Id_client"));
                client.setFullName(rs.getString("full_name"));
                client.setUserName(rs.getString("user_name"));
                client.setGender(rs.getString("gender"));
                client.setPhone(rs.getString("phone"));
                clients.add(client);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return clients;
    }

}
