package com.js.cars_library_java.controller;
import com.js.cars_library_java.service.CarsService;
import com.js.cars_library_java.model.Car;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class CarsController {
    @Autowired
    CarsService carsService;

    @GetMapping("/cars")
    public String carsList(Model m){
        m.addAttribute("cars", carsService.getAllCars());
        return "cars";
    }

    @GetMapping("/cars/new")
    public String showCarForm(Model model){
        Car car = new Car();
        model.addAttribute("car", car);
        return "add_car";
    }

    @PostMapping("/cars/add")
    public String addCar(@Valid Car car, BindingResult binding){
        if (binding.hasErrors()) {
            return "add_car";
        }
        else {
            carsService.saveCar(car);
            return "redirect:/cars";
        }
    }
    @GetMapping("/cars/edit/{id}")
    public String showEditCarForm(@PathVariable Long id, Model model){
        model.addAttribute("car",carsService.getCarById(id));
        return "edit_car";
    }

    @PostMapping("/cars/update/{id}")
    public String updateCar(@PathVariable Long id, @Valid Car car, BindingResult binding){
        if (binding.hasErrors()) {
            return "edit_car";
        }
        carsService.updateCar(id, car);
        return "redirect:/cars";
    }

    @GetMapping("/cars/delete/{id}")
    public String deleteCar(@PathVariable Long id){
        carsService.deleteCar(id);
        return "redirect:/cars";
    }
}
