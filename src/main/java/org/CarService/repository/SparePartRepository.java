package org.CarService.repository;

import org.CarService.entity.SparePart;
import org.CarService.mapper.SparePartMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SparePartRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public SparePartRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<SparePart> findAll() {
        return jdbcTemplate.query("SELECT * FROM spare_part", new SparePartMapperImpl());
    }

      /*   public void saveCar(){
          jdbcTemplate.update("INSERT INTO car VALUES")
     }

     public Car findById(){

     }

     public void deleteById(int id){

     }*/

}
