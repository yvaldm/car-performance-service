package com.yvaldm.performance.carperformanceservice.transformer;

import com.yvaldm.performance.carperformanceservice.api.CarRequestResponse;
import com.yvaldm.performance.carperformanceservice.api.TrackRequest;
import com.yvaldm.performance.carperformanceservice.api.TrackResponse;
import com.yvaldm.performance.carperformanceservice.api.ValueRequestResponse;
import com.yvaldm.performance.carperformanceservice.entity.Car;
import com.yvaldm.performance.carperformanceservice.entity.Track;
import com.yvaldm.performance.carperformanceservice.entity.Value;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Static utility class for transforming from request to entity and vice versa -- from entity to response
 *
 * @author valeryyakovlev
 */
public class Transformer {

    public static Track toTrackEntity(TrackRequest request) {
        return new Track(request.getId(), request.getName(), request.getDescription(),
                         new Value(request.getLength().getValue(), request.getLength().getUnit()));
    }

    public static Car toCarEntity(CarRequestResponse carRequestResponse) {

        ValueRequestResponse valueRequest = carRequestResponse.getMaxSpeed();
        Value value = toValueEntity(valueRequest);

        return new Car(carRequestResponse.getId(),
                       carRequestResponse.getTrackId(), carRequestResponse.getCode(),
                       carRequestResponse.getTransmission(),
                       carRequestResponse.getAi(),
                       value);
    }

    private static Value toValueEntity(ValueRequestResponse value) {
        return new Value(value.getValue(), value.getUnit());
    }

    public static List<TrackResponse> toTracksResponse(List<Track> tracks) {
        return tracks.stream().map(Transformer::toTrackResponse).collect(toList());
    }

    private static TrackResponse toTrackResponse(Track track) {
        ValueRequestResponse length = new ValueRequestResponse(track.getLength().getValue(), track.getLength().getUnit());
        return new TrackResponse(track.getId(), track.getName(), track.getDescription(), length, toCarResponses(track.getCars()));
    }

    private static ValueRequestResponse toValueResponse(Value length) {
        return new ValueRequestResponse(length.getValue(), length.getUnit());
    }

    private static List<CarRequestResponse> toCarResponses(List<Car> cars) {
        return cars.stream().map(Transformer::toCarResponse).collect(toList());
    }

    private static CarRequestResponse toCarResponse(Car car) {
        return new CarRequestResponse(car.getId(), car.getTrackId(), car.getCode(), car.getTransmission(),
                                      car.getAi(), toValueResponse(car.getMaxSpeed()));
    }
}
