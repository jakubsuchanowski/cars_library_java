package com.js.cars_library_java;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends JpaRepository<Car, Long> {

}
