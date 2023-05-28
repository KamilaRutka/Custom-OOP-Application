package com.example.carrent.service;

import com.example.carrent.model.Car;
import com.example.carrent.repository.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CarService implements ApplicationRunner {

    private CarRepository carRepository;

    public Car getCarById(Long id) {
        return carRepository.findById(id).get();
    }

    public List<Car> getCars() {
        return carRepository.findAll();
    }

    public void addNewCar(Car car) {
        carRepository.save(car);
    }

    @Override
    public void run(final ApplicationArguments args) {
        this.addNewCar(Car.builder()
                .brand("BMW").registrationNumber("SK77123").seats(4).rented(false).build());
        this.addNewCar(Car.builder()
                .brand("Opel").registrationNumber("SD74123").seats(4).rented(false).build());
        this.addNewCar(Car.builder()
                .brand("Fiat").registrationNumber("JG2134").seats(3).rented(false).build());
    }
}
