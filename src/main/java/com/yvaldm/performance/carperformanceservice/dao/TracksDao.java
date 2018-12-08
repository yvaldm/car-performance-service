package com.yvaldm.performance.carperformanceservice.dao;

import com.yvaldm.performance.carperformanceservice.entity.Track;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import java.math.BigDecimal;
import java.util.List;

/**
 * Data access object for track entity
 *
 * @author valeryyakovlev
 */
public class TracksDao {

    private static final String INSERT = "insert into track (name, description, length, unit) " +
            "values(:name, :description, :length, :unit) returning id";

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public TracksDao(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public long insert(String name, String description, BigDecimal length, String unit) {

        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("name", name)
                .addValue("description", description)
                .addValue("length", length)
                .addValue("unit", unit);

        return jdbcTemplate.queryForObject(INSERT, params, long.class);
    }

    public List<Track> find() {


        return null;
    }
}
