package org.CarService.controller;

import org.CarService.entity.SparePart;
import org.CarService.service.SparePartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("sparePart")
public class SparePartController {
    @Autowired
    private final SparePartService sparePartService;

    public SparePartController(SparePartService sparePartService) {
        this.sparePartService = sparePartService;
    }

    @GetMapping("/spareParts")
    public List<SparePart> getSpareParts() {
        return this.sparePartService.getSpareParts();
    }
}
