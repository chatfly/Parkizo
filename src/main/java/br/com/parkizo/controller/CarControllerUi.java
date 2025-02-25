package br.com.parkizo.controller;

import br.com.parkizo.entity.Car;
import br.com.parkizo.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Controller
@RequestMapping("/parkizo/car/ui")
public class CarControllerUi {

    private final CarService carService;

    @GetMapping("/list")
    public String getAll(Model model) {
        List<Car> carList = carService.getAll();
        model.addAttribute("cars", carList);
        return "listCars";
    }

    @GetMapping("/list/{id}")
    public String getById(@PathVariable Long id, Model model) {
        Optional<Car> car = carService.getById(id);
        if(car.isPresent()) {
            model.addAttribute("car", car.get());
            model.addAttribute("totalTime", carService.getTotalTime(id));
            return "carDetails";
        }
        return "redirect:/parkizo/car/list";
    }

    @GetMapping("/register")
    public String registerACar(Model model) {
        model.addAttribute("car", new Car());
        return "registerCar";
    }

    @PostMapping("/save")
    public String saveACarParked(@ModelAttribute Car car, RedirectAttributes redirectAttributes) {
        carService.createPark(car);
        redirectAttributes.addFlashAttribute("message", "Car saved successfully");
        return "redirect:/parkizo/car/ui/list";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCar(@PathVariable Long id) {
        carService.finishPark(id);
        return "redirect:/parkizo/car/ui/list";
    }

}
