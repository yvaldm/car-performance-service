package com.yvaldm.performance.carperformanceservice.controller;

import com.yvaldm.performance.carperformanceservice.api.TracksRequestResponse;
import com.yvaldm.performance.carperformanceservice.service.TrackService;
import com.yvaldm.performance.carperformanceservice.transformer.Transformer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for track data
 *
 * @author valeryyakovlev
 */
@RestController
public class TrackController {

    private final TrackService trackService;

    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }

    @PostMapping("/tracks")
    public void saveMetrics(@RequestBody TracksRequestResponse request) {
        trackService.create(Transformer.toTrackEntity(request));
    }
}
