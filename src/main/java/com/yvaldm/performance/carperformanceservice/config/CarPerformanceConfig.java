package com.yvaldm.performance.carperformanceservice.config;

import com.yvaldm.performance.carperformanceservice.dao.CarsDao;
import com.yvaldm.performance.carperformanceservice.dao.TracksDao;
import com.yvaldm.performance.carperformanceservice.service.CarService;
import com.yvaldm.performance.carperformanceservice.service.TrackService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Car performance application configuration
 *
 * @author valeryyakovlev
 */
@Configuration
public class CarPerformanceConfig {

    @Bean
    public CarService metricsService(CarsDao carsDao) {
        return new CarService(carsDao);
    }

    @Bean
    public TrackService trackService(TracksDao tracksDao, CarsDao carsDao) {
        return new TrackService(tracksDao, carsDao);
    }
}
