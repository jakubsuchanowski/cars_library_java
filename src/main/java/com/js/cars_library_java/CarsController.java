package com.js.cars_library_java;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("/cars")
    public String addCar(@ModelAttribute("car") Car car){
        carsService.saveCar(car);
        return "redirect:/cars";

    }
    @GetMapping("/cars/edit/{id}")
    public String showEditCarForm(@PathVariable Long id, Model model){
        model.addAttribute("car",carsService.getCarById(id));
        return "edit_car";
    }

    @PostMapping("/cars/{id}")
    public String updateCar(@PathVariable Long id, @ModelAttribute("car") Car car, Model model){
        Car existCar = carsService.getCarById(id);
        existCar.setBrand(car.getBrand());
        existCar.setModel(car.getModel());
        carsService.updateCar(existCar);
        return "redirect:/cars";
    }

    @GetMapping("/cars/{id}")
    public String deleteCar(@PathVariable Long id){
        carsService.deleteCar(id);
        return "redirect:/cars";
    }

    @GetMapping("/cars/details/{id}")
    public String showCarDetails(@PathVariable Long id, Model model){
        model.addAttribute("car",carsService.getCarById(id));
        return "car_details";
    }


}
