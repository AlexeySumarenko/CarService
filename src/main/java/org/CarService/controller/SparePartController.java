package org.CarService.controller;

import org.CarService.dto.SparePartDto;
import org.CarService.entity.SparePart;
import org.CarService.service.SparePartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("spareParts")
@CrossOrigin("http://localhost:3000")
public class SparePartController {
    @Autowired
    private final SparePartService sparePartService;

    public SparePartController(SparePartService sparePartService) {
        this.sparePartService = sparePartService;
    }

    @GetMapping()
    public List<SparePart> getAllSpareParts() {
        return this.sparePartService.findAllSpareParts();
    }

    @PostMapping()
    public String saveSparePart(@RequestBody SparePartDto sparePartDto){
        return this.sparePartService.saveSparePart(sparePartDto);
    }
    @GetMapping("/{id}")
    public SparePart findSparePart(@PathVariable int id){
        return this.sparePartService.findSparePartById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteSparePart(@PathVariable int id){
        return this.sparePartService.deleteSparePart(id);}

    @PutMapping("/{id}")
    public SparePart updateSparePart(@PathVariable int id, @RequestBody SparePartDto sparePartDto) {
        return this.sparePartService.updateSparePart(id, sparePartDto);
    }
}
