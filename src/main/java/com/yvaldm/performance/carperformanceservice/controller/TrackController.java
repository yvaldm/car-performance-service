package com.yvaldm.performance.carperformanceservice.controller;

import com.yvaldm.performance.carperformanceservice.api.TrackRequest;
import com.yvaldm.performance.carperformanceservice.api.TrackResponse;
import com.yvaldm.performance.carperformanceservice.entity.Track;
import com.yvaldm.performance.carperformanceservice.service.TrackService;
import com.yvaldm.performance.carperformanceservice.transformer.Transformer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller for tracks
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
    public void create(@RequestBody TrackRequest request) {
        Track track = Transformer.toTrackEntity(request);
        trackService.create(track.getName(), track.getDescription(), track.getLength().getValue(), track.getLength().getUnit());
    }

    @GetMapping("/tracks")
    public List<TrackResponse> find() {
        return Transformer.toTracksResponse(trackService.find());
    }
}
