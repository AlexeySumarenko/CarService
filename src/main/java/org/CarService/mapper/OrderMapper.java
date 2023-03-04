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
        order.setDateOfReceiving(rs.getDate("date_of_receiving"));
        order.setDateOfCompletion(rs.getDate("date_of_completion"));
        order.setIdClient(rs.getInt("id_client"));
        order.setIdEmployee(rs.getInt("id_employee"));
        order.setPrice(rs.getDouble("price"));
        order.setStatus(rs.getString("status"));
        order.setIdCar(rs.getInt("id_car"));
        order.setIdService(rs.getInt("id_service"));
        order.setIdSparePart(rs.getInt("id_spare_part"));
        return order;
    }
}
