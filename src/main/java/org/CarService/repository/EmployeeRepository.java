package org.CarService.repository;


import org.CarService.entity.Employee;
import org.CarService.repository.Mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepository {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public EmployeeRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Employee> findAll() {
        return jdbcTemplate.query("SELECT * FROM employee", new EmployeeMapper());
    }

      /*   public void saveCar(){
          jdbcTemplate.update("INSERT INTO car VALUES")
     }

     public Car findById(){

     }

     public void deleteById(int id){

     }*/

}
