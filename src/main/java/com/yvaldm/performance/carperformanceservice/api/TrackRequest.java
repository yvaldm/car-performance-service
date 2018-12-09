package com.yvaldm.performance.carperformanceservice.api;

/**
 * Track request/response
 *
 * @author valeryyakovlev
 */
public class TrackRequest {

    private long id;
    private String name;
    private String description;
    private ValueRequestResponse length;

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
}
