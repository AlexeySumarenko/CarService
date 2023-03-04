package org.CarService.repository;

import org.CarService.entity.Producer;
import org.CarService.entity.Service;
import org.CarService.mapper.ProducerMapperImpl;
import org.CarService.mapper.ServiceMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class ServiceRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ServiceRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Service> findAll() {
        return jdbcTemplate.query("SELECT * FROM service", new ServiceMapperImpl());
    }
    @Transactional
    public int saveService(Service newService) {
        System.out.println(newService);
        jdbcTemplate.update("INSERT INTO service (service_name, price, guarantee, id_employee) VALUES ( ?, ?, ?, ?) ", newService.getServiceName(), newService.getPrice(), newService.getGuarantee(), newService.getIdEmployee());
        return jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);
    }

    public Service updateService(int id, Service updatedService) {
        jdbcTemplate.update("UPDATE service SET service_name=?, price=?, guarantee=? WHERE id_service=?",
                updatedService.getServiceName(), updatedService.getPrice(), updatedService.getGuarantee(), id);
        return updatedService;
    }

    public Service findById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM service WHERE id_service = ?", new ServiceMapperImpl(), id);
    }

    public String deleteServiceById(int id) {
        jdbcTemplate.update("DELETE FROM service WHERE id_service=?", id);
        return "Service got deleted with id = " + id;
    }
}
