package org.CarService.mapper;

import org.CarService.dto.CarDto;
import org.CarService.entity.Car;
import org.mapstruct.Mapper;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


@Mapper
public interface CarMapper extends RowMapper<Car> {
    CarDto CarToCarDTO(Car car);

    Car CarDtoToCar(CarDto carDTO);

    @Override
    default Car mapRow(ResultSet rs, int rowNum) throws SQLException {
        Car car = new Car();
        car.setIdCar(rs.getInt("id_car"));
        car.setIdClient(rs.getInt("id_client"));
        car.setCarBrand(rs.getString("car_brand"));
        car.setModel(rs.getString("model"));
        car.setType(rs.getString("type"));
        car.setReleaseYear(rs.getInt("release_year"));
        return car;
    }
}
