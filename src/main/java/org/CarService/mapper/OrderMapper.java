package org.CarService.mapper;

import org.CarService.dto.OrderDto;
import org.CarService.entity.Car;
import org.CarService.entity.Order;
import org.mapstruct.Mapper;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

@Mapper
public interface OrderMapper extends RowMapper<Order> {
    OrderDto OrderToOrderDto(Order order);
    Order OrderDtoToOrder(OrderDto orderDto);

    @Override
    default Order mapRow(ResultSet rs, int rowNum) throws SQLException {
        Order order = new Order();
        order.setIdOrder(rs.getInt("id_order"));
        order.setDateOfReceiving(rs.getString("date_of_receipt"));
        order.setPrice(rs.getDouble("price"));
        order.setDateOfCompletion(rs.getString("date_of_completion"));
        order.setStatus(rs.getString("status"));

        return order;
    }
}
