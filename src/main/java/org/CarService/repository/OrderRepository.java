package org.CarService.repository;

import org.CarService.entity.Client;
import org.CarService.entity.Employee;
import org.CarService.entity.Order;
import org.CarService.mapper.ClientMapperImpl;
import org.CarService.mapper.OrderMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class OrderRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public OrderRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Order> findAll() {
        return jdbcTemplate.query("SELECT * FROM order", new OrderMapperImpl());
    }
    @Transactional
    public int saveOrder(Order newOrder) {
        System.out.println(newOrder);
        jdbcTemplate.update("INSERT INTO `order` (date_of_receiving, date_of_completion, id_client, id_employee, price, `status`, id_car, id_spare_part, id_service) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)", newOrder.getDateOfReceiving(), newOrder.getDateOfCompletion(), newOrder.getIdClient(), newOrder.getIdEmployee(), newOrder.getPrice(), newOrder.getStatus(), newOrder.getIdCar(), newOrder.getIdSparePart(), newOrder.getIdService());
        return jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);
    }

    public Order updateOrder(int id, Order updatedOrder) {
        jdbcTemplate.update("UPDATE order SET date_of_receiving=?, date_of_completion=?, id_client=?, id_employee=?, price=?, status=?, id_car=?, id_spare_part=?, id_service=? WHERE id_order=?", updatedOrder.getDateOfReceiving(), updatedOrder.getDateOfCompletion(), updatedOrder.getIdClient(), updatedOrder.getIdEmployee(), updatedOrder.getPrice(), updatedOrder.getStatus(), updatedOrder.getIdCar(), updatedOrder.getIdSparePart(), updatedOrder.getIdService(), id);
        return updatedOrder;
    }

    public Order findById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM order WHERE id_order = ?", new OrderMapperImpl(), id);
    }

    public String deleteOrderById(int id) {
        jdbcTemplate.update("DELETE FROM order WHERE id_order=?", id);
        return "Order got deleted with id = " + id;
    }
}
