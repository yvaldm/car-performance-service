package com.yvaldm.performance.carperformanceservice.api;

import java.math.BigDecimal;
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
    private BigDecimal length;
    private String unit;
    private List<CarRequestResponse> cars;

    public TrackResponse(long id, String name, String description, BigDecimal length, String unit, List<CarRequestResponse> cars) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.length = length;
        this.unit = unit;
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

    public BigDecimal getLength() {
        return length;
    }

    public String getUnit() {
        return unit;
    }

    public List<CarRequestResponse> getCars() {
        return cars;
    }
}
