package com.yvaldm.performance.carperformanceservice.entity;

import java.util.ArrayList;
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
    private List<Car> cars = new ArrayList<>();

    public Track(long id, String name, String description, Value length) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.length = length;
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

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
