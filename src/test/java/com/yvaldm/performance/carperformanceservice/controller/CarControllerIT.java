package com.yvaldm.performance.carperformanceservice.controller;

import com.yvaldm.performance.carperformanceservice.config.TestEmbeddedConfig;
import com.yvaldm.performance.carperformanceservice.service.TrackService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@Import({TestEmbeddedConfig.class})
@SpringBootTest
@Transactional
@AutoConfigureMockMvc
public class CarControllerIT {

    @Autowired
    private TrackService trackService;

    @Autowired
    private MockMvc mvc;

    @Test
    public void shouldCreateCar() throws Exception {

        // arrange
        long id = trackService.create("track1", "description1", BigDecimal.valueOf(123.321), "km");

        // act
        mvc.perform(post("/cars")
                            .content("{ \"id\": \"2\", " +
                                             " \"track_id\": \"" + id + " \"," +
                                             "   \"code\": \"rdb1\", " +
                                             "   \"transmission\": \"automatic\", " +
                                             "   \"ai\": \"enabled\", " +
                                             "   \"max-speed\": { " +
                                             "    \"unit\": \"mps\", " +
                                             "    \"value\": 110.12121212 " +
                                             "   } }")
                            .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk());
    }
}