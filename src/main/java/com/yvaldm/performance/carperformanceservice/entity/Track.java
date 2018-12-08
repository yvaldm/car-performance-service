package com.yvaldm.performance.carperformanceservice.entity;

import java.util.List;

/**
 * Track entity
 *
 * @author valeryyakovlev
 */
public class Track {

    private long id;
    private String name;
    private String description;
    private Value length;
    private List<Car> cars;

    public Track(long id, String name, String description, Value length) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.length = length;
    }

    public Track(long id, String name, String description, Value length, List<Car> cars) {
        this(id, name, description, length);
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

    public Value getLength() {
        return length;
    }

    public List<Car> getCars() {
        return cars;
    }
}
