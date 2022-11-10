package org.CarService.repository;

import org.CarService.entity.Car;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CarRepository {
     private final DataSource dataSource;

     public CarRepository(@Qualifier DataSource dataSource) {
          this.dataSource = dataSource;
     }

     public List<Car> findAll() {
          List<Car> cars = new ArrayList<>();
          String sqlQuery = "SELECT id_car, id_client, car_brand, model, type, release_year FROM car";
          try (Connection con = dataSource.getConnection();
               PreparedStatement ps = con.prepareStatement(sqlQuery);
               ResultSet rs = ps.executeQuery()) {
               while(rs.next()) {
                    var car = new Car();
                    car.setIdCar(rs.getInt("Id_car"));
                    car.setIdClient(rs.getInt("id_client"));
                    car.setCarBrand(rs.getString("car_brand"));
                    car.setModel(rs.getString("model"));
                    car.setType(rs.getString("type"));
                    car.setReleaseYear(rs.getInt("release_year"));
                    cars.add(car);
               }
          } catch (SQLException e) {
               throw new RuntimeException(e);
          }
          return cars;
     }

}
