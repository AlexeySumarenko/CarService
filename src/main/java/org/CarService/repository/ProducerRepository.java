package org.CarService.repository;

import org.CarService.entity.Producer;
import org.CarService.mapper.ProducerMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProducerRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ProducerRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Producer> findAll() {
        return jdbcTemplate.query("SELECT * FROM producer", new ProducerMapperImpl());
    }

      /*   public void saveCar(){
          jdbcTemplate.update("INSERT INTO car VALUES")
     }

     public Car findById(){

     }

     public void deleteById(int id){

     }*/

}
