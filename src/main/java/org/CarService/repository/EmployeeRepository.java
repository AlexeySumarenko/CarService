package org.CarService.repository;

import org.CarService.entity.Client;
import org.CarService.entity.Employee;
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
public class EmployeeRepository {
    private final DataSource dataSource;

    public EmployeeRepository(@Autowired DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Employee> findAll() {
        List<Employee> employees = new ArrayList<>();
        String sqlQuery = "SELECT id_employee, full_name, job_position, age, phone, address FROM employee";
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(sqlQuery);
             ResultSet rs = ps.executeQuery()) {
            while(rs.next()) {
                var employee = new Employee();
                employee.setIdEmployee(rs.getInt("id_employee"));
                employee.setFullName(rs.getString("full_name"));
                employee.setJobPosition(rs.getString("job_position"));
                employee.setAge(rs.getInt("age"));
                employee.setPhone(rs.getString("phone"));
                employee.setAddress(rs.getString("address"));
                employees.add(employee);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employees;
    }

}
