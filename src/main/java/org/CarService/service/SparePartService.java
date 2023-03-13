package org.CarService.service;

import org.CarService.dto.SparePartDto;
import org.CarService.entity.SparePart;
import org.CarService.mapper.SparePartMapper;
import org.CarService.mapper.SparePartMapperImpl;
import org.CarService.repository.SparePartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SparePartService {
    @Autowired
    public SparePartRepository sparePartRepository;

    private SparePartMapper sparePartMapper = new SparePartMapperImpl();

    public List<SparePart> findAllSpareParts() {
        return sparePartRepository.findAll();
    }

    public String deleteSparePart(int id) {
        return sparePartRepository.deleteSparePartById(id);
    }

    public String saveSparePart(SparePartDto sparePartDto){
        sparePartRepository.saveSparePart(sparePartMapper.SparePartDtoToSparePart(sparePartDto));
        return "SparePart saved successfully";
    }
    public SparePart updateSparePart(int id, SparePartDto sparePartDto){
        return sparePartRepository.updateSparePart(id, sparePartMapper.SparePartDtoToSparePart(sparePartDto));
    }

    public SparePart findSparePartById(int id){
        return sparePartRepository.findById(id);
    }
    public int getPageCount(int quantity){
        int Count = sparePartRepository.getCount();
        return (int) Math.ceil((double) Count/quantity);
    }
    public int getCount(){
        return sparePartRepository.getCount();
    }
}
