package com.yvaldm.performance.carperformanceservice.dao;

import com.yvaldm.performance.carperformanceservice.entity.Track;
import com.yvaldm.performance.carperformanceservice.entity.Value;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Data Access Object for Track entity
 *
 * @author valeryyakovlev
 */
public class TracksDao {

    private static final String INSERT = "insert into track (name, description, length, unit) " +
            "values(:name, :description, :length, :unit) returning id";

    private static final String SELECT = "select * from track";

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
        return jdbcTemplate.query(SELECT, TracksDao::mapRow);
    }

    private static Track mapRow(ResultSet resultSet, int i) throws SQLException {
        long id = resultSet.getLong("id");
        String name = resultSet.getString("name");
        String description = resultSet.getString("description");
        BigDecimal length = resultSet.getObject("length", BigDecimal.class);
        String unit = resultSet.getString("unit");

        return new Track(id, name, description, new Value(length, unit));
    }

}
