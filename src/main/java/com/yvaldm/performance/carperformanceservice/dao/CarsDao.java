package com.yvaldm.performance.carperformanceservice.dao;

import com.yvaldm.performance.carperformanceservice.entity.Car;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

/**
 * @author valeryyakovlev
 */
public class CarsDao {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    private static final String INSERT = "insert into car (code, transmission, ai, value, unit) " +
            "values(:code, :transmission, :ai, :value, :unit) returning id";

    public CarsDao(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public long insert(Car car) {

        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("code", car.getCode())
                .addValue("transmission", car.getTransmission().toString())
                .addValue("ai", car.getCode().toString())
                .addValue("value", car.getMaxSpeed().getValue())
                .addValue("unit", car.getMaxSpeed().getUnit());

        return jdbcTemplate.queryForObject(INSERT, param, long.class);
    }
}
