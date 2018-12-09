package com.yvaldm.performance.carperformanceservice.service;

import com.yvaldm.performance.carperformanceservice.dao.CarsDao;
import com.yvaldm.performance.carperformanceservice.entity.Car;

/**
 * Cars Service
 *
 * @author valeryyakovlev
 */
public class CarService {

    private final CarsDao carsDao;

    public CarService(CarsDao carsDao) {
        this.carsDao = carsDao;
    }

    public void create(Car car) {
        carsDao.insert(car.getCode(), car.getTrackId(),
                       car.getTransmission(), car.getAi(), car.getMaxSpeed().getValue(), car.getMaxSpeed().getUnit());
    }
}
