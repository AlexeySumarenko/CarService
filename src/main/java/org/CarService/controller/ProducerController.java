package org.CarService.controller;

import org.CarService.dto.ProducerDto;
import org.CarService.entity.Producer;
import org.CarService.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("producers")
@CrossOrigin("http://localhost:3000")
public class ProducerController {
    @Autowired
    private final ProducerService producerService;

    public ProducerController(ProducerService producerService) {
        this.producerService = producerService;
    }

    @GetMapping()
    public List<Producer> getAllProducers() {
        return this.producerService.findAllProducers();
    }

    @PostMapping()
    public String saveProducer(@RequestBody ProducerDto producerDto){
        return this.producerService.saveProducer(producerDto);
    }
    @GetMapping("/{id}")
    public Producer findProducer(@PathVariable int id){
        return this.producerService.findProducerById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteProducer(@PathVariable int id){
        return this.producerService.deleteProducer(id);}

    @PutMapping("/{id}")
    public Producer updateProducer(@PathVariable int id, @RequestBody ProducerDto producerDto) {
        return this.producerService.updateProducer(id, producerDto);
    }
}
