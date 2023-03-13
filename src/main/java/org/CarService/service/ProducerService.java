package org.CarService.service;

import org.CarService.dto.ProducerDto;
import org.CarService.entity.Producer;
import org.CarService.mapper.ProducerMapper;
import org.CarService.mapper.ProducerMapperImpl;
import org.CarService.repository.ProducerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProducerService {
    @Autowired
    public ProducerRepository producerRepository;

    private ProducerMapper producerMapper = new ProducerMapperImpl();

    public List<Producer> findAllProducers() {
        return producerRepository.findAll();
    }

    public String deleteProducer(int id) {
        return producerRepository.deleteProducerById(id);
    }

    public String saveProducer(ProducerDto producerDto){
        producerRepository.saveProducer(producerMapper.ProducerDtoToProducer(producerDto));
        return "Producer saved successfully";
    }
    public Producer updateProducer(int id, ProducerDto producerDto){
        return producerRepository.updateProducer(id, producerMapper.ProducerDtoToProducer(producerDto));
    }

    public Producer findProducerById(int id){
        return producerRepository.findById(id);
    }
    public int getPageCount(int quantity){
        int Count = producerRepository.getCount();
        return (int) Math.ceil((double) Count/quantity);
    }
    public int getCount(){
        return producerRepository.getCount();
    }
}
