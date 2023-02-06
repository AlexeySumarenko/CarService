package org.CarService.service;

import org.CarService.dto.OrderDto;
import org.CarService.entity.Order;
import org.CarService.mapper.OrderMapper;
import org.CarService.mapper.OrderMapperImpl;
import org.CarService.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    public OrderRepository orderRepository;

    private OrderMapper orderMapper = new OrderMapperImpl();
    public List<Order> findAllOrders() {
        return orderRepository.findAll();
    }

    public String deleteOrder(int id) {
        return orderRepository.deleteOrderById(id);
    }

    public String saveOrder(OrderDto orderDto){
        orderRepository.saveOrder(orderMapper.OrderDtoToOrder(orderDto));
        return "Order saved successfully";
    }
    public Order updateOrder(int id, OrderDto orderDto){
        return orderRepository.updateOrder(id, orderMapper.OrderDtoToOrder(orderDto));
    }

    public Order findOrderById(int id){
        return orderRepository.findById(id);
    }
}
