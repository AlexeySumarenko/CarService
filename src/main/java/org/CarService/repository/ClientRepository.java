package org.CarService.repository;


import org.CarService.entity.Car;
import org.CarService.entity.Client;
import org.CarService.mapper.CarMapperImpl;
import org.CarService.mapper.ClientMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class ClientRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ClientRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Client> findAll() {
        return jdbcTemplate.query("SELECT * FROM client", new ClientMapperImpl());
    }
    public int getCount(){
        return jdbcTemplate.queryForObject("SELECT count(*) FROM client", Integer.class);
    }
    @Transactional
    public int saveClient(Client newClient) {
        System.out.println(newClient);
        jdbcTemplate.update("INSERT INTO client (full_name, user_name, password, gender, phone) VALUES (?, ?, ?, ?, ?) ", newClient.getFullName(), newClient.getUserName(), newClient.getPassword(), newClient.getGender(), newClient.getPhone());
        return jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);
    }
    /*public Client updateClient(int id, Client updatedClient) {
        jdbcTemplate.update("UPDATE client SET id_client=?, full_name=?, user_name=?, password=?, gender=?, phone=? WHERE id_client=?",
                updatedClient.getIdClient(), updatedClient.getFullName(), updatedClient.getUserName(), updatedClient.getPassword(), updatedClient.getGender(), updatedClient.getPhone(), id);
        return updatedClient;
    }*/

    public Client updateDtoClient(int id, Client updatedClient) {
        jdbcTemplate.update("UPDATE client SET full_name=?, user_name=?, gender=?, phone=? WHERE id_client=?",
                updatedClient.getFullName(), updatedClient.getUserName(), updatedClient.getGender(), updatedClient.getPhone(), id);
        return updatedClient;
    }
    public Client findById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM client WHERE id_client = ?", new ClientMapperImpl(), id);
    }
    public String deleteClientById(int id) {
        jdbcTemplate.update("DELETE FROM client WHERE id_client=?", id);
        return "Client got deleted with id = " + id;
    }

}
