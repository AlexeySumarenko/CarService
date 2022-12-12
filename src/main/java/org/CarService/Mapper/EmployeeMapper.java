package org.CarService.Mapper;

import org.CarService.entity.Client;
import org.CarService.entity.Employee;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeMapper implements RowMapper<Employee> {
    @Override
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
        Employee employee = new Employee();
        employee.setIdEmployee(rs.getInt("id_employee"));
        employee.setFullName(rs.getString("full_name"));
        employee.setJobPosition(rs.getString("job_position"));
        employee.setAge(rs.getInt("age"));
        employee.setPhone(rs.getString("phone"));
        employee.setAddress(rs.getString("address"));

        return employee;
    }
}
