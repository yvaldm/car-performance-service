package com.yvaldm.performance.carperformanceservice.api;

import java.util.List;

/**
 * Track request/response
 *
 * @author valeryyakovlev
 */
public class TrackResponse {

    private long id;
    private String name;
    private String description;
    private ValueRequestResponse length;
    private List<CarRequestResponse> cars;

    public TrackResponse(long id, String name, String description, ValueRequestResponse length, List<CarRequestResponse> cars) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.length = length;
        this.cars = cars;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public ValueRequestResponse getLength() {
        return length;
    }

    public List<CarRequestResponse> getCars() {
        return cars;
    }
}
