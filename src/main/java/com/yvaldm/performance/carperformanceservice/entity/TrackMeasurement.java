package com.yvaldm.performance.carperformanceservice.entity;

import java.util.List;

public class TrackMeasurement {

    private long id;
    private String name;
    private String description;
    private List<Car> cars;

    public TrackMeasurement(long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public TrackMeasurement(long id, String name, String description, List<Car> cars) {
        this(id, name, description);
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

    public List<Car> getCars() {
        return cars;
    }
}
