package org.CarService.mapper;

import org.CarService.dto.ServiceDto;
import org.CarService.entity.Car;
import org.CarService.entity.Service;
import org.mapstruct.Mapper;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

@Mapper
public interface ServiceMapper extends RowMapper<Service> {
    ServiceDto ServiceToServiceDto(Service service);
    Service ServiceDtoToService(ServiceDto serviceDto);

    @Override
    default Service mapRow(ResultSet rs, int rowNum) throws SQLException {
        Service service = new Service();
        service.setIdService(rs.getInt("id_employee"));
        service.setServiceName(rs.getString("service_name"));
        service.setGuarantee(rs.getString("guarantee"));
        service.setPrice(rs.getDouble("price"));

        return service;
    }
}
