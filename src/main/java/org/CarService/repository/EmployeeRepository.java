package org.CarService.repository;


import org.CarService.entity.Employee;
import org.CarService.mapper.EmployeeMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class EmployeeRepository {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public EmployeeRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Employee> findAll() {
        return jdbcTemplate.query("SELECT * FROM employee", new EmployeeMapperImpl());
    }
    @Transactional
    public int saveEmployee(Employee newEmployee) {
        System.out.println(newEmployee);
        jdbcTemplate.update("INSERT INTO employee (full_name, job_position, age, phone, " +
                        "address) VALUES ( ?, ?, ?, ?, ?) ", newEmployee.getFullName()
                , newEmployee.getJobPosition(), newEmployee.getAge(), newEmployee.getPhone(),
                newEmployee.getAddress());
        return jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);
    }

    public Employee updateEmployee(int id, Employee updatedEmployee) {
        jdbcTemplate.update("UPDATE employee SET full_name=?, job_position=?, age=?, " +
                        "phone=?, address=? WHERE id_employee=?",
                updatedEmployee.getFullName(), updatedEmployee.getJobPosition(), updatedEmployee.getAge(),
                updatedEmployee.getPhone(), updatedEmployee.getAddress(), id);
        return updatedEmployee;
    }

    public Employee findById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM employee WHERE id_employee=?",
                new EmployeeMapperImpl(), id);
    }

    public String deleteEmployeeById(int id) {
        jdbcTemplate.update("DELETE FROM employee WHERE id_employee=?", id);
        return "Employee got deleted with id = " + id;
    }

}
