package com.yvaldm.performance.carperformanceservice.service;

import com.yvaldm.performance.carperformanceservice.dao.TracksDao;
import com.yvaldm.performance.carperformanceservice.entity.Track;

import java.util.List;

/**
 * @author valeryyakovlev
 */
public class TrackService {

    private final TracksDao tracksDao;

    public TrackService(TracksDao tracksDao) {
        this.tracksDao = tracksDao;
    }

    public void create(Track track) {
        tracksDao.insert(track.getName(), track.getDescription(), track.getLength().getValue(), track.getLength().getUnit());
    }

    public List<Track> find() {
        return tracksDao.find();
    }
}
