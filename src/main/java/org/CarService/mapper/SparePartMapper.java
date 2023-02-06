package org.CarService.mapper;

import org.CarService.dto.SparePartDto;
import org.CarService.entity.Car;
import org.CarService.entity.SparePart;
import org.mapstruct.Mapper;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

@Mapper
public interface SparePartMapper extends RowMapper<SparePart> {
    SparePartDto SparePartToSparePartDto(SparePart sparePart);
    SparePart SparePartDtoToSparePart(SparePartDto sparePartDto);

    @Override
    default SparePart mapRow(ResultSet rs, int rowNum) throws SQLException {
        SparePart sparePart = new SparePart();
        sparePart.setIdSparePart(rs.getInt("id_spare_part"));
        sparePart.setSparePartName(rs.getString("name"));
        sparePart.setPrice(rs.getDouble("price"));
        sparePart.setQuantity(rs.getInt("quantity"));

        return sparePart;
    }
}
