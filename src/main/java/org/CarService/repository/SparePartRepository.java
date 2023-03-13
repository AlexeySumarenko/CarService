package org.CarService.repository;

import org.CarService.entity.Service;
import org.CarService.entity.SparePart;
import org.CarService.mapper.ServiceMapperImpl;
import org.CarService.mapper.SparePartMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class SparePartRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public SparePartRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<SparePart> findAll() {
        return jdbcTemplate.query("SELECT * FROM spare_part", new SparePartMapperImpl());
    }
    public int getCount(){
        return jdbcTemplate.queryForObject("SELECT count(*) FROM spare_part", Integer.class);
    }

    @Transactional
    public int saveSparePart(SparePart newSparePart) {
        System.out.println(newSparePart);
        jdbcTemplate.update("INSERT INTO spare_part (spare_part_name, price, quantity, id_producer) VALUES ( ?, ?, ?, ?) ", newSparePart.getSparePartName(), newSparePart.getPrice(), newSparePart.getQuantity(), newSparePart.getIdProducer());
        return jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);
    }
    public SparePart updateSparePart(int id, SparePart updatedSparePart) {
        jdbcTemplate.update("UPDATE spare_part SET spare_part_name=?, price=?, quantity=? WHERE id_spare_part=?",
                updatedSparePart.getSparePartName(), updatedSparePart.getPrice(), updatedSparePart.getQuantity(), id);
        return updatedSparePart;
    }

    public SparePart findById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM spare_part WHERE id_spare_part=?", new SparePartMapperImpl(), id);
    }

    public String deleteSparePartById(int id) {
        jdbcTemplate.update("DELETE FROM spare_part WHERE id_spare_part=?", id);
        return "SparePart got deleted with id = " + id;
    }
}
