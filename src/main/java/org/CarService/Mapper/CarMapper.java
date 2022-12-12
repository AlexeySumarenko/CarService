package org.CarService.Mapper;


import org.CarService.entity.Car;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CarMapper implements RowMapper<Car> {
    @Override
    public Car mapRow(ResultSet rs, int rowNum) throws SQLException {
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
