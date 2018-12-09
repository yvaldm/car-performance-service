package com.yvaldm.performance.carperformanceservice.dao;

import com.yvaldm.performance.carperformanceservice.api.ArtificialIntelligence;
import com.yvaldm.performance.carperformanceservice.api.Transmission;
import com.yvaldm.performance.carperformanceservice.entity.Car;
import com.yvaldm.performance.carperformanceservice.entity.Value;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Data Access Object for Cars
 *
 * @author valeryyakovlev
 */
public class CarsDao {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    private static final String INSERT = "insert into car (code, track_id, transmission, ai, value, unit) " +
            "values(:code, :track_id, :transmission, :ai, :value, :unit) returning id";

    private static final String SELECT = "select * from car";

    public CarsDao(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public long insert(String code, long trackId, Transmission transmission, ArtificialIntelligence ai,
                       BigDecimal value, String unit) {

        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("code", code)
                .addValue("track_id", trackId)
                .addValue("transmission", transmission.toString())
                .addValue("ai", ai.toString())
                .addValue("value", value)
                .addValue("unit", unit);

        return jdbcTemplate.queryForObject(INSERT, param, long.class);
    }

    public List<Car> find() {
        return jdbcTemplate.query(SELECT, CarsDao::mapRow);
    }

    private static Car mapRow(ResultSet resultSet, int i) throws SQLException {
        long id = resultSet.getLong("id");
        long trackId = resultSet.getLong("track_id");
        String code = resultSet.getString("code");
        String transmission = resultSet.getString("transmission");
        String ai = resultSet.getString("ai");
        BigDecimal value = resultSet.getBigDecimal("value");
        String unit = resultSet.getString("unit");

        return new Car(id, trackId, code, Transmission.valueOf(transmission),
                       ArtificialIntelligence.valueOf(ai), new Value(value, unit));
    }
}
