package com.yvaldm.performance.carperformanceservice.api;

import java.util.List;

public class TracksRequestResponse {

    private long id;
    private String name;
    private String description;
    private MeasurementRequestResponse length;
    private List<CarRequestResponse> cars;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public MeasurementRequestResponse getLength() {
        return length;
    }

    public List<CarRequestResponse> getCars() {
        return cars;
    }
}
