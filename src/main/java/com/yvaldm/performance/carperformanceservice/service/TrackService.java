package com.yvaldm.performance.carperformanceservice.service;

import com.yvaldm.performance.carperformanceservice.dao.CarsDao;
import com.yvaldm.performance.carperformanceservice.dao.TracksDao;
import com.yvaldm.performance.carperformanceservice.entity.Car;
import com.yvaldm.performance.carperformanceservice.entity.Track;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

/**
 * Tracks service
 *
 * @author valeryyakovlev
 */
public class TrackService {

    private final TracksDao tracksDao;
    private final CarsDao carsDao;

    public TrackService(TracksDao tracksDao, CarsDao carsDao) {
        this.tracksDao = tracksDao;
        this.carsDao = carsDao;
    }

    /**
     * Create track entity
     *
     * @param name        track name
     * @param description track description
     * @param length      length of the track
     * @param unit        measurement unit for length
     * @return identifier of newly created track
     */
    public long create(String name, String description, BigDecimal length, String unit) {
        return tracksDao.insert(name, description, length, unit);
    }

    /**
     * Find all available tracks with cars result assiociated with the track
     *
     * @return list of tracks
     */
    public List<Track> find() {
        List<Track> tracks = tracksDao.find();
        Map<Long, List<Car>> carsMap = carsDao.find().stream().collect(groupingBy(Car::getTrackId));
        tracks.forEach(t -> t.setCars(carsMap.computeIfAbsent(t.getId(), z -> new ArrayList<>())));
        return tracks;
    }
}
