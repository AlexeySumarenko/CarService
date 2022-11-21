package org.CarService.repository;

import org.CarService.entity.Service;
import org.CarService.repository.Mapper.ServiceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ServiceRepository {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ServiceRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Service> findAll() {
        return jdbcTemplate.query("SELECT * FROM service", new ServiceMapper());
    }

      /*   public void saveCar(){
          jdbcTemplate.update("INSERT INTO car VALUES")
     }

     public Car findById(){

     }

     public void deleteById(int id){

     }*/

}
