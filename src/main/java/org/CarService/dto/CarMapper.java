package org.CarService.dto;

import org.CarService.entity.Car;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

@Service
@Mapper
public interface CarMapper {
    CarDto CarToCarDTO(Car car);

    Car CarDtoToCar(CarDto carDTO);
}
