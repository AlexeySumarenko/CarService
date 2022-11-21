package org.CarService.repository.Mapper;

import org.CarService.entity.Employee;
import org.CarService.entity.Producer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProducerMapper implements RowMapper<Producer> {
    @Override
    public Producer mapRow(ResultSet rs, int rowNum) throws SQLException {
        Producer producer = new Producer();
        producer.setId_producer(rs.getInt("id_producer"));
        producer.setAddress(rs.getString("address"));
        producer.setCompany(rs.getString("company"));
        return producer;
    }
}
