package com.yvaldm.performance.carperformanceservice.transformer;

import com.yvaldm.performance.carperformanceservice.api.CarRequestResponse;
import com.yvaldm.performance.carperformanceservice.api.MeasurementRequestResponse;
import com.yvaldm.performance.carperformanceservice.api.TracksRequestResponse;
import com.yvaldm.performance.carperformanceservice.entity.Car;
import com.yvaldm.performance.carperformanceservice.entity.TrackMeasurement;
import com.yvaldm.performance.carperformanceservice.entity.Value;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class Transformer {

    public static List<TrackMeasurement> toTrackEntities(List<TracksRequestResponse> tracks) {
        return tracks.stream().map(Transformer::toTrackEntity).collect(toList());
    }

    private static TrackMeasurement toTrackEntity(TracksRequestResponse request) {
        List<CarRequestResponse> cars = request.getCars();
        List<Car> carEntities = cars.stream().map(Transformer::toCarEntity).collect(toList());
        return new TrackMeasurement(request.getId(), request.getName(), request.getDescription(), carEntities);
    }

    private static Car toCarEntity(CarRequestResponse carRequestResponse) {

        MeasurementRequestResponse valueRequest = carRequestResponse.getMaxSpeed();

        Value value = toValueEntity(valueRequest);
        return new Car(carRequestResponse.getId(),
                       carRequestResponse.getCode(),
                       carRequestResponse.getTransmission(),
                       carRequestResponse.getAi(),
                       value);
    }

    private static Value toValueEntity(MeasurementRequestResponse maxSpeed) {
        return new Value(maxSpeed.getValue(), maxSpeed.getUnit());
    }
}
