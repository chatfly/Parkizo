package br.com.parkizo.service;

import br.com.parkizo.entity.Car;
import br.com.parkizo.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;

    public List<Car> getAll() {
        return carRepository.findAll();
    }

    public Car createPark(Car car) {
        return carRepository.save(car);
    }

}
