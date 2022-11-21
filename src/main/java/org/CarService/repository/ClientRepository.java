package org.CarService.repository;


import org.CarService.entity.Client;
import org.CarService.repository.Mapper.ClientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClientRepository {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ClientRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Client> findAll() {
        return jdbcTemplate.query("SELECT * FROM client", new ClientMapper());
    }

      /*   public void saveCar(){
          jdbcTemplate.update("INSERT INTO car VALUES")
     }

     public Car findById(){

     }

     public void deleteById(int id){

     }*/

}
