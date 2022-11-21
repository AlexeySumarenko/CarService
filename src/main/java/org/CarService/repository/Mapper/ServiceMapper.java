package org.CarService.repository.Mapper;

import org.CarService.entity.Employee;
import org.CarService.entity.Service;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ServiceMapper implements RowMapper<Service> {
    @Override
    public Service mapRow(ResultSet rs, int rowNum) throws SQLException {
        Service service = new Service();
        service.setId_service(rs.getInt("id_employee"));
        service.setService_name(rs.getString("service_name"));
        service.setGuarantee(rs.getString("guarantee"));
        service.setPrice(rs.getDouble("price"));

        return service;
    }
}
