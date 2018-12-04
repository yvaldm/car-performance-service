package com.yvaldm.performance.carperformanceservice.config;

import com.yvaldm.performance.carperformanceservice.dao.CarsDao;
import com.yvaldm.performance.carperformanceservice.dao.TracksDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

/**
 * Data access configuration
 *
 * @author valeryyakovlev
 */
@Configuration
public class DataAccessConfig {

    @Bean
    public CarsDao carsDao(NamedParameterJdbcTemplate jdbcTemplate) {
        return new CarsDao(jdbcTemplate);
    }

    @Bean
    public TracksDao tracksDao(NamedParameterJdbcTemplate jdbcTemplate) {
        return new TracksDao(jdbcTemplate);
    }
}
