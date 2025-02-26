package br.com.parkizo.mapper;

import br.com.parkizo.controller.request.CarRequest;
import br.com.parkizo.controller.response.CarResponse;
import br.com.parkizo.entity.Car;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CarMapper {

    public static Car toCar(CarRequest request){
        return Car.builder()
                .licensePlate(request.licensePlate())
                .build();
    }

    public static CarResponse toCarResponse(Car car){
        return CarResponse.builder()
                .id(car.getId())
                .licensePlate(car.getLicensePlate())
                .arrivalTime(car.getArrivalTime())
                .build();
    }

}
