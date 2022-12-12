package org.CarService.repository;

import org.CarService.entity.Car;
import org.CarService.Mapper.CarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarRepository {
    private JdbcTemplate jdbcTemplate;
    @Autowired
    public CarRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<Car> findAll() {
        return jdbcTemplate.query("SELECT * FROM car", new CarMapper());
    }
    public Car saveCar(Car newCar) {
        jdbcTemplate.update("INSERT INTO car (idCar, idClient, carBrand, model, type, releaseYear) VALUES (?, ?, ?, " +
                        "?, ?, ?) ", newCar.getIdCar(), newCar.getIdClient(), newCar.getCarBrand(), newCar.getModel(),
                newCar.getType(), newCar.getReleaseYear());
        return newCar;
    }
    public Car update(int id, Car updatedCar) {
        jdbcTemplate.update("UPDATE Car SET idCar=?, idClient=?, carBrand=?, model=?, type=?, releaseYear=? WHERE id=?",
                updatedCar.getIdCar(), updatedCar.getIdClient(), updatedCar.getCarBrand(), updatedCar.getModel(),
                updatedCar.getType(), updatedCar.getReleaseYear(), id);
        return updatedCar;
    }
    public Car findById(int id) {
       return jdbcTemplate.queryForObject("SELECT * FROM car WHERE id=?", new CarMapper(),id);
    }
    public String deleteCarById(int id) {
        jdbcTemplate.update("DELETE FROM car WHERE id=?", id);
        return "Car got deleted with id = " + id;
    }
}
