package com.ciesla.rentyourdreamscarrental.repository;

import com.ciesla.rentyourdreamscarrental.entity.Car;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CarRepository extends CrudRepository<Car, Integer> {
    List<Car> findAll();
    List<Car> findAllByOrderByTimesRentedDesc();
    List<Car> findAllByBrandName(String name);
    List<Car> findAllByModel(String model);
    Car findCarById(Integer id);
}
