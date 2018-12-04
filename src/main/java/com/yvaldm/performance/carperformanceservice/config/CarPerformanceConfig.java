package com.yvaldm.performance.carperformanceservice.config;

import com.yvaldm.performance.carperformanceservice.dao.CarsDao;
import com.yvaldm.performance.carperformanceservice.dao.TracksDao;
import com.yvaldm.performance.carperformanceservice.service.MetricsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CarPerformanceConfig {

    @Bean
    public MetricsService metricsService(CarsDao carsDao, TracksDao tracksDao){
        return new MetricsService(carsDao, tracksDao);
    }
}
