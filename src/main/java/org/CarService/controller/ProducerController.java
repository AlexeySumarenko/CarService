package org.CarService.controller;

import org.CarService.entity.Producer;
import org.CarService.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("producer")
public class ProducerController {
    @Autowired
    private final ProducerService producerService;

    public ProducerController(ProducerService producerService) {
        this.producerService = producerService;
    }

    @GetMapping("/producers")
    public List<Producer> getProducers() {
        return this.producerService.getProducers();
    }
}
