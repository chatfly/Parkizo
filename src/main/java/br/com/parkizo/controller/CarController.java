package br.com.parkizo.controller;

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
    public List<Car> getAllCars() {
        return carService.getAll();
    }

    @PostMapping("/")
    public Car createPark(@RequestBody Car car) {
        return carService.createPark(car);
    }

    @DeleteMapping("/pay/{id}")
    public String finishPark(@PathVariable Long id) {
        return carService.finishPark(id);
    }



}
