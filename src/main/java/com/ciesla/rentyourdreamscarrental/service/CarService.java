package com.ciesla.rentyourdreamscarrental.service;

import com.ciesla.rentyourdreamscarrental.entity.Car;
import com.ciesla.rentyourdreamscarrental.repository.CarRepository;
import com.ciesla.rentyourdreamscarrental.repository.RentalRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    private final CarRepository carRepository;
    private final RentalRequestRepository rentalRequestRepository;

    @Autowired
    public CarService(CarRepository carRepository, RentalRequestRepository rentalRequestRepository) {
        this.carRepository = carRepository;
        this.rentalRequestRepository = rentalRequestRepository;
    }

    public List<Car> showAllCars() {
        return carRepository.findAll();
    }

    public List<Car> showAllCarsByPopularity() {
        return carRepository.findAllByOrderByTimesRentedDesc();
    }

    public List<Car> showCarsByBrandName(String name) {
        return carRepository.findAllByBrandName(name);
    }

    public List<Car> showCarsByModel(String model) {
        return carRepository.findAllByModel(model);
    }

    public Car showCarById(Integer id) {
        return carRepository.findCarById(id);
    }

    public void save(Car car) {
        carRepository.save(car);
    }

    public void delete(Integer id) {
        carRepository.delete(id);
    }

    public Integer getNumberOfRequests() {
        Integer numberOfRequests = Integer.parseInt(String.valueOf(rentalRequestRepository.count()));
        return numberOfRequests;
    }
}
