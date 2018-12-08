package com.yvaldm.performance.carperformanceservice.transformer;

import com.yvaldm.performance.carperformanceservice.api.CarRequestResponse;
import com.yvaldm.performance.carperformanceservice.api.MeasurementRequestResponse;
import com.yvaldm.performance.carperformanceservice.api.TracksRequestResponse;
import com.yvaldm.performance.carperformanceservice.entity.Car;
import com.yvaldm.performance.carperformanceservice.entity.TrackMeasurement;
import com.yvaldm.performance.carperformanceservice.entity.Value;

public class Transformer {

    public static TrackMeasurement toTrackEntity(TracksRequestResponse request) {
        return new TrackMeasurement(request.getId(), request.getName(), request.getDescription(), null);
    }

    public static Car toCarEntity(CarRequestResponse carRequestResponse) {

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
