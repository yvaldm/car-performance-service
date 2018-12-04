package com.yvaldm.performance.carperformanceservice.controller;

import com.yvaldm.performance.carperformanceservice.api.MetricsRequestResponse;
import com.yvaldm.performance.carperformanceservice.service.MetricsService;
import com.yvaldm.performance.carperformanceservice.transformer.Transformer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for car performance application
 *
 * @author valeryyakovlev
 */
@RestController
public class CarPerformanceController {

    private final MetricsService metricsService;

    public CarPerformanceController(MetricsService metricsService) {
        this.metricsService = metricsService;
    }

    @PostMapping("/metrics/save")
    public void saveMetrics(@RequestBody MetricsRequestResponse request) {
        metricsService.saveMetrics(Transformer.toTrackEntities(request.getTracks()));
    }
}
