package com.yvaldm.performance.carperformanceservice.controller;

import com.yvaldm.performance.carperformanceservice.api.CarRequestResponse;
import com.yvaldm.performance.carperformanceservice.service.CarService;
import com.yvaldm.performance.carperformanceservice.transformer.Transformer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest Controller for car data
 *
 * @author valeryyakovlev
 */
@RestController
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping("/cars")
    public void create(@RequestBody CarRequestResponse request) {
        carService.create(Transformer.toCarEntity(request));
    }
}
