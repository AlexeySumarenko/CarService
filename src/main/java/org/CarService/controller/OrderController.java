package org.CarService.controller;

import org.CarService.dto.OrderDto;
import org.CarService.entity.Order;
import org.CarService.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("orders")
@CrossOrigin("http://localhost:3000")
public class OrderController {
    @Autowired
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    @GetMapping()
    public List<Order> getAllOrders() {
        return this.orderService.findAllOrders();
    }

    @PostMapping()
    public String saveOrder(@RequestBody OrderDto orderDto){
        return this.orderService.saveOrder(orderDto);
    }
    @GetMapping("/{id}")
    public Order findOrder(@PathVariable int id){
        return this.orderService.findOrderById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteOrder(@PathVariable int id){
        return this.orderService.deleteOrder(id);}

    @PutMapping("/{id}")
    public Order updateOrder(@PathVariable("id") int id, @RequestBody OrderDto orderDto) {
        return this.orderService.updateOrder(id, orderDto);
    }
}
