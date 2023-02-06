package org.CarService;

import org.CarService.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GenerateDataApp implements CommandLineRunner {
    @Autowired
    private CarRepository carRepository;

    public static void main( String[] args ) {
        SpringApplication.run(GenerateDataApp.class);

    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(this.carRepository.findAll());

    }
}
