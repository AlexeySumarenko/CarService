package org.CarService.repository;

import org.CarService.entity.Car;
import org.CarService.mapper.CarMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CarRepository {
    private final JdbcTemplate jdbcTemplate;


    @Autowired
    public CarRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Car> findAll(int offset, int quantity) {
        return jdbcTemplate.query("SELECT * FROM car ORDER BY id_car ASC LIMIT ?, ?", new CarMapperImpl(), offset, quantity);
    }

    public int getCount(){
        return jdbcTemplate.queryForObject("SELECT count(*) FROM car", Integer.class);
    }
    @Transactional
    public int saveCar(Car newCar) {
/*
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
*/
        System.out.println(newCar);
        jdbcTemplate.update("INSERT INTO car (id_client, car_brand, model, `type`, release_year) VALUES ( ?, ?, ?, ?, ?) ", newCar.getIdClient(), newCar.getCarBrand(), newCar.getModel(),
                newCar.getType(), newCar.getReleaseYear());
/*
        int i = generatedKeyHolder.getKey().intValue();
*/
        return jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);
    }

    public Car updateCar(int id, Car updatedCar) {
        jdbcTemplate.update("UPDATE Car SET id_client=?, car_brand=?, model=?, `type`=?, release_year=? WHERE id_car=?",
                updatedCar.getIdClient(), updatedCar.getCarBrand(), updatedCar.getModel(),
                updatedCar.getType(), updatedCar.getReleaseYear(), id);
        return updatedCar;
    }

    public Car findById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM car WHERE id_car = ?", new CarMapperImpl(), id);
    }

    public String deleteCarById(int id) {
        jdbcTemplate.update("DELETE FROM car WHERE id_car=?", id);
        return "Car got deleted with id = " + id;
    }
}
