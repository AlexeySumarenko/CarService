package org.CarService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.*;

@SpringBootApplication
public class App
{
    public static void main( String[] args ) throws SQLException {
        SpringApplication.run(App.class);

        Connection connection  = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/car_service",
                "root", "12345");
        Statement statement = connection.createStatement();
        ResultSet results = statement.executeQuery("SELECT * FROM car");
        while (results.next()) {
            int id = results.getInt(1);
            String name = results.getString(3);
            System.out.println(results.getRow() + ". " + id + "\t"+ name);
        }
        connection.close();
    }
}
