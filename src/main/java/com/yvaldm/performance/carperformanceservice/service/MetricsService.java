package com.yvaldm.performance.carperformanceservice.service;

import com.yvaldm.performance.carperformanceservice.dao.CarsDao;
import com.yvaldm.performance.carperformanceservice.dao.TracksDao;
import com.yvaldm.performance.carperformanceservice.entity.TrackMeasurement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author valeryyakovlev
 */
public class MetricsService {

    private final CarsDao carsDao;
    private final TracksDao tracksDao;

    public MetricsService(CarsDao carsDao, TracksDao tracksDao) {
        this.carsDao = carsDao;
        this.tracksDao = tracksDao;
    }

    @Transactional
    public void saveMetrics(List<TrackMeasurement> tracks) {

        for (TrackMeasurement track : tracks) {

            long id = tracksDao.insert(track.getName(), track.getDescription());
            carsDao.insert(track.getCars());
        }

    }
}
