package com.yvaldm.performance.carperformanceservice.service;

import com.yvaldm.performance.carperformanceservice.dao.TracksDao;
import com.yvaldm.performance.carperformanceservice.entity.TrackMeasurement;

/**
 * @author valeryyakovlev
 */
public class TrackService {

    private final TracksDao tracksDao;

    public TrackService(TracksDao tracksDao) {
        this.tracksDao = tracksDao;
    }

    public void create(TrackMeasurement track) {
        tracksDao.insert(track.getName(), track.getDescription());
    }
}
