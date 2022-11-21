package org.CarService.service;

import org.CarService.entity.Employee;
import org.CarService.entity.Order;
import org.CarService.repository.EmployeeRepository;
import org.CarService.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    public OrderRepository orderRepository;

    public List<Order> getOrders(){
        return orderRepository.findAll();
}
}
