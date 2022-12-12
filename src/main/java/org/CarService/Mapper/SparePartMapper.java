package org.CarService.Mapper;

import org.CarService.entity.Employee;
import org.CarService.entity.SparePart;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SparePartMapper implements RowMapper<SparePart> {
    @Override
    public SparePart mapRow(ResultSet rs, int rowNum) throws SQLException {
        SparePart sparePart = new SparePart();
        sparePart.setIdSparePart(rs.getInt("id_spare_part"));
        sparePart.setName(rs.getString("name"));
        sparePart.setPrice(rs.getDouble("price"));
        sparePart.setQuantity(rs.getInt("quantity"));

        return sparePart;
    }
}
