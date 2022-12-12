package org.CarService.Mapper;

import org.CarService.entity.Employee;
import org.CarService.entity.Order;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderMapper implements RowMapper<Order> {

    @Override
    public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
        Order order = new Order();
        order.setIdOrder(rs.getInt("id_order"));
        order.setDateOfReceiving(rs.getString("date_of_receipt"));
        order.setPrice(rs.getDouble("price"));
        order.setDateOfCompletion(rs.getString("date_of_completion"));
        order.setStatus(rs.getString("status"));

        return order;
    }
}
