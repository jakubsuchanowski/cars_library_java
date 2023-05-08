package com.js.cars_library_java;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class CarsService {

    @Autowired
    CarRepository carRepository;
    public List<Car> getAllCars(){
        return carRepository.findAll();
    }
    public Car saveCar(Car car){
        return carRepository.save(car);
    }

    public Car getCarById(Long id){
        return carRepository.findById(id).get();
    }
    public Car updateCar(Car car){
        return carRepository.save(car);
    }

    public void deleteCar(Long id){
        carRepository.deleteById(id);
    }
}
