package org.CarService.repository;

import org.CarService.entity.Car;
import org.CarService.entity.Producer;
import org.CarService.mapper.CarMapperImpl;
import org.CarService.mapper.ProducerMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class ProducerRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ProducerRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Producer> findAll() {
        return jdbcTemplate.query("SELECT * FROM producer", new ProducerMapperImpl());
    }
    public int getCount(){
        return jdbcTemplate.queryForObject("SELECT count(*) FROM producer", Integer.class);
    }
    @Transactional
    public int saveProducer(Producer newProducer) {
        System.out.println(newProducer);
        jdbcTemplate.update("INSERT INTO producer (company, address) VALUES ( ?, ?) ", newProducer.getCompany(), newProducer.getAddress());
        return jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);
    }
    public Producer updateProducer(int id, Producer updatedProducer) {
        jdbcTemplate.update("UPDATE producer SET company=?, address=? WHERE id_producer=?",
                updatedProducer.getCompany(), updatedProducer
                        .getAddress(), id);
        return updatedProducer;
    }
    public Producer findById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM producer WHERE id_producer = ?", new ProducerMapperImpl(), id);
    }

    public String deleteProducerById(int id) {
        jdbcTemplate.update("DELETE FROM producer WHERE id_producer=?", id);
        return "Producer got deleted with id = " + id;
    }
}
