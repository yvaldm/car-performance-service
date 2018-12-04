package com.yvaldm.performance.carperformanceservice.dao;

import com.yvaldm.performance.carperformanceservice.config.TestEmbeddedConfig;
import com.yvaldm.performance.carperformanceservice.entity.TrackMeasurement;
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
        long id = tracksDao.insert("some", "description");

        // assert
        TrackMeasurement trackMeasurement = jdbcTemplate.queryForObject("select * from track where id=:id", singletonMap("id", id), ROW_MAPPER);

        assertThat(trackMeasurement.getId()).isNotNull();
        assertThat(trackMeasurement.getName()).isEqualTo("some");
        assertThat(trackMeasurement.getDescription()).isEqualTo("description");
    }

    public static final RowMapper<TrackMeasurement> ROW_MAPPER = (resultSet, i) -> {
        long id = resultSet.getLong("id");
        String name = resultSet.getString("name");
        String description = resultSet.getString("description");
        return new TrackMeasurement(id, name, description);
    };
}