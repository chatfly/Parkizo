package br.com.parkizo.controller;

import br.com.parkizo.mapper.CarMapper;
import br.com.parkizo.controller.request.CarRequest;
import br.com.parkizo.controller.response.CarResponse;
import br.com.parkizo.entity.Car;
import br.com.parkizo.service.CarService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/parkizo/car")
public class CarController {

    private final CarService carService;

    @GetMapping("/")
    public ResponseEntity<List<CarResponse>> getAllCars() {
        return ResponseEntity.ok(carService.getAll()
                .stream()
                .map(CarMapper::toCarResponse)
                .toList());
    }

    @PostMapping("/")
    public ResponseEntity<CarResponse> createPark(@Valid @RequestBody CarRequest car) {
        Car parkCreated = carService.createPark(CarMapper.toCar(car));
        return ResponseEntity.status(HttpStatus.CREATED).body(CarMapper.toCarResponse(parkCreated));
    }

    @DeleteMapping("/pay/{id}")
    public ResponseEntity finishPark(@PathVariable Long id) {
        return ResponseEntity.ok(carService.finishPark(id));
    }

}
