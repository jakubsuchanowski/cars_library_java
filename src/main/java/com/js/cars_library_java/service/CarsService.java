package com.js.cars_library_java.service;

import com.js.cars_library_java.model.Car;
import com.js.cars_library_java.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarsService {

    @Autowired
    CarRepository carRepository;
    public Iterable<Car> getAllCars(){
        return carRepository.findAll();
    }
    public void saveCar(Car car){
        carRepository.save(car);
    }

    public Car getCarById(Long id){
         return carRepository.findById(id).get();
    }
    public void updateCar(Long id, Car car){
        Optional<Car> existCar = carRepository.findById(id);
            existCar.get().setBrand(car.getBrand());
            existCar.get().setModel(car.getModel());
            existCar.get().setProductionYear(car.getProductionYear());
            existCar.get().setPowerHp(car.getPowerHp());
            existCar.get().setEngineCapacity(car.getEngineCapacity());
            existCar.get().setFuelType(car.getFuelType());
            existCar.get().setDrive(car.getDrive());
            existCar.get().setTransmission(car.getTransmission());
            existCar.get().setType(car.getType());
            existCar.get().setDoorsNumber(car.getDoorsNumber());
            carRepository.save(existCar.get());
    }

    public void deleteCar(Long id){
        carRepository.deleteById(id);
    }
}
