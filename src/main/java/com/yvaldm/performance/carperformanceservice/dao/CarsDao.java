package com.yvaldm.performance.carperformanceservice.dao;

import com.yvaldm.performance.carperformanceservice.entity.Car;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;

/**
 * @author valeryyakovlev
 */
public class CarsDao {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public CarsDao(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public long insert(List<Car> cars) {

        //jdbcTemplate.update("insert into car")
        return 0;
    }
}
