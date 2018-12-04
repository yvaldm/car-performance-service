package com.yvaldm.performance.carperformanceservice.dao;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

/**
 * Data access object for track entity
 *
 * @author valeryyakovlev
 */
public class TracksDao {

    private static final String INSERT = "insert into track (name, description) " +
            "values(:name, :description) returning id";

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public TracksDao(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public long insert(String name, String description) {

        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("name", name)
                .addValue("description", description);

        return jdbcTemplate.queryForObject(INSERT, params, long.class);
    }
}
