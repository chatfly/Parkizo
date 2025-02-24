package br.com.parkizo.controller;

import br.com.parkizo.entity.Car;
import br.com.parkizo.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

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

}
