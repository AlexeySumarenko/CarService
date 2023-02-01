package org.CarService.mapper;

import org.CarService.dto.ProducerDto;
import org.CarService.entity.Car;
import org.CarService.entity.Producer;
import org.mapstruct.Mapper;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

@Mapper
public interface ProducerMapper extends RowMapper<Producer> {
    ProducerDto ProducerToProducerDto(Producer producer);
    Producer ProducerDtoToProducer(ProducerDto producerDto);

    @Override
    default Producer mapRow(ResultSet rs, int rowNum) throws SQLException {
        Producer producer = new Producer();
        producer.setId_producer(rs.getInt("id_producer"));
        producer.setAddress(rs.getString("address"));
        producer.setCompany(rs.getString("company"));
        return producer;
    }
}
