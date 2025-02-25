package br.com.parkizo.service;

import br.com.parkizo.entity.Car;
import br.com.parkizo.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.CurrentTimestamp;
import org.hibernate.grammars.hql.HqlParser;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;

    public List<Car> getAll() {
        return carRepository.findAll();
    }

    public Optional<Car> getById(Long id) {
        return carRepository.findById(id);
    }

    public Car createPark(Car car) {
        return carRepository.save(car);
    }

    public String finishPark(Long id) {
        Optional<Car> car = carRepository.findById(id);
        if(car.isPresent()){
            carRepository.deleteById(id);
            return "Park finished with success";
        }
        return "Car with Id: " + id + " doesn't exists";
    }

    public Optional<Integer> getTotalTime(Long id) {
        Optional<Car> car = carRepository.findById(id);
        if (car.isPresent()) {
            LocalDateTime currentTime = LocalDateTime.now();
            LocalDateTime arrivalTime = car.get().getArrivalTime();

            Duration duration = Duration.between(arrivalTime, currentTime);

            return Optional.of((int) Math.ceil(duration.toHours()));
        }
        return Optional.empty();
    }


}
