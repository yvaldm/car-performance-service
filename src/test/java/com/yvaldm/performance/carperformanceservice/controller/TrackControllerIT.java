package com.yvaldm.performance.carperformanceservice.controller;

import com.yvaldm.performance.carperformanceservice.api.ArtificialIntelligence;
import com.yvaldm.performance.carperformanceservice.api.Transmission;
import com.yvaldm.performance.carperformanceservice.config.TestEmbeddedConfig;
import com.yvaldm.performance.carperformanceservice.dao.CarsDao;
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

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@Import({TestEmbeddedConfig.class})
@SpringBootTest
@Transactional
@AutoConfigureMockMvc
public class TrackControllerIT {

    @Autowired
    private TrackService trackService;

    @Autowired
    private CarsDao carsDao;

    @Autowired
    private MockMvc mvc;

    @Test
    public void shouldCreateTrack() throws Exception {

        mvc.perform(post("/tracks")
                            .content("{ " +
                                             "  \"id\": 1, " +
                                             "  \"name\": \"Millbrook\", " +
                                             "  \"description\": \"Millbrook city course race track\", " +
                                             "  \"length\": { " +
                                             "   \"value\": 7.4, " +
                                             "   \"unit\": \"km\" " +
                                             "  }" +
                                             "}")
                            .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldRetrieveAllTracks() throws Exception {

        // arrange
        mvc.perform(post("/tracks")
                            .content("{ \"name\": \"track1\", " +
                                             "  \"description\": \"descr1\", " +
                                             "  \"length\": { " +
                                             "   \"value\": 222.333, " +
                                             "   \"unit\": \"km\" " +
                                             "  }" +
                                             "}")
                            .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk());

        mvc.perform(post("/tracks")
                            .content("{ \"name\": \"track2\", " +
                                             "  \"description\": \"descr2\", " +
                                             "  \"length\": { " +
                                             "   \"value\": 443.123, " +
                                             "   \"unit\": \"km\"" +
                                             "  }" +
                                             "}")
                            .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk());

        // act
        mvc.perform(get("/tracks"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[*].name", containsInAnyOrder("track1", "track2")));
    }

    @Test
    public void shouldRetrieveTrackWithCars() throws Exception {

        // arrange
        long trackId = trackService.create("some track", "some description", BigDecimal.valueOf(666.777), "km");

        carsDao.insert("some code", trackId, Transmission.automatic, ArtificialIntelligence.enabled, BigDecimal.valueOf(233.32), "km/h");
        carsDao.insert("some code2", trackId, Transmission.manual, ArtificialIntelligence.disabled, BigDecimal.valueOf(3.32), "km/h");

        // act
        mvc.perform(get("/tracks"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("some track"))
                .andExpect(jsonPath("$[0].cars[*].code", containsInAnyOrder("some code", "some code2")))
                .andExpect(jsonPath("$[0].cars[*].transmission", containsInAnyOrder(Transmission.manual.toString(),
                                                                                    Transmission.automatic.toString())));
    }
}