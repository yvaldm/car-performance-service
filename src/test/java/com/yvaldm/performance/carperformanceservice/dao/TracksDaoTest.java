package com.yvaldm.performance.carperformanceservice.dao;

import com.yvaldm.performance.carperformanceservice.config.TestEmbeddedConfig;
import com.yvaldm.performance.carperformanceservice.entity.Track;
import com.yvaldm.performance.carperformanceservice.entity.Value;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

import static java.util.Collections.singletonMap;
import static org.assertj.core.api.Java6Assertions.assertThat;


@RunWith(SpringRunner.class)
@Import({TestEmbeddedConfig.class})
@SpringBootTest
@Transactional
@AutoConfigureMockMvc
public class TracksDaoTest {

    @Autowired
    private TracksDao tracksDao;

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Test
    public void shouldPersistTrack() {

        // act
        long id = tracksDao.insert("some", "description", BigDecimal.valueOf(666.666), "km");

        // assert
        Track trackMeasurement = jdbcTemplate.queryForObject("select * from track where id=:id", singletonMap("id", id), ROW_MAPPER);

        assertThat(trackMeasurement.getId()).isNotNull();
        assertThat(trackMeasurement.getName()).isEqualTo("some");
        assertThat(trackMeasurement.getDescription()).isEqualTo("description");
        assertThat(trackMeasurement.getLength().getValue()).isEqualTo(BigDecimal.valueOf(666.666));
        assertThat(trackMeasurement.getLength().getUnit()).isEqualTo("km");
    }

    public static final RowMapper<Track> ROW_MAPPER = (resultSet, i) -> {
        long id = resultSet.getLong("id");
        String name = resultSet.getString("name");
        String description = resultSet.getString("description");

        BigDecimal length = resultSet.getBigDecimal("length");
        String unit = resultSet.getString("unit");

        return new Track(id, name, description, new Value(length, unit));
    };
}