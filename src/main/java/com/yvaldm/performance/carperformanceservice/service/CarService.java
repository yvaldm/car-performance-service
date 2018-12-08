package com.yvaldm.performance.carperformanceservice.service;

import com.yvaldm.performance.carperformanceservice.dao.CarsDao;
import com.yvaldm.performance.carperformanceservice.entity.Car;

/**
 * @author valeryyakovlev
 */
public class CarService {

    private final CarsDao carsDao;

    public CarService(CarsDao carsDao) {
        this.carsDao = carsDao;
    }

    public void create(Car car) {
        carsDao.insert(car);
    }
}
