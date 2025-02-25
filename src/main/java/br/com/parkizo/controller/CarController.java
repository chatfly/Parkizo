package br.com.parkizo.controller;

import br.com.parkizo.controller.mapper.CarMapper;
import br.com.parkizo.controller.request.CarRequest;
import br.com.parkizo.controller.response.CarResponse;
import br.com.parkizo.entity.Car;
import br.com.parkizo.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/parkizo/car")
public class CarController {

    private final CarService carService;

    @GetMapping("/")
    public List<CarResponse> getAllCars() {
        return carService.getAll()
                .stream()
                .map(CarMapper::toCarResponse)
                .toList();
    }

    @PostMapping("/")
    public CarResponse createPark(@RequestBody CarRequest car) {
        Car parkCreated = carService.createPark(CarMapper.toCar(car));
        return CarMapper.toCarResponse(parkCreated);
    }

    @DeleteMapping("/pay/{id}")
    public void finishPark(@PathVariable Long id) {
        carService.finishPark(id);
    }



}
