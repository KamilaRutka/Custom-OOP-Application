package com.example.carrent.service;

import com.example.carrent.dto.RentDTO;
import com.example.carrent.model.Car;
import com.example.carrent.model.Rent;
import com.example.carrent.repository.CarRepository;
import com.example.carrent.repository.PersonRepository;
import com.example.carrent.repository.RentRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class RentService {

    private RentRepository rentRepository;
    private PersonRepository personRepository;
    private CarRepository carRepository;

    @Transactional
    public void addNewRent(RentDTO rentDTO) {
        Rent rent = new Rent();

        rent.setPerson(personRepository.findById(rentDTO.getUserId()).get());
        Car car = carRepository.findById(rentDTO.getCarId()).get();
        car.setRented(true);
        rent.setCars(List.of(car));
        rent.setRentBy(LocalDateTime.now());
        rent.setRentEnd(LocalDate.now().plusDays(rentDTO.getDays()).atStartOfDay());
        car.setRent(rentRepository.save(rent));


    }

    @Transactional
    public void deleteRent(Long id) {
        Rent rent = rentRepository.findById(id).get();
        rent.getCars().forEach(car -> car.setRent(null));
        rentRepository.deleteById(id);
    }

    public List<Rent> getRents() {
        return rentRepository.findAll();
    }

    public List<Rent> getRentByPersonEmail(String personEmail) {
        return rentRepository.getAllByPersonEmail(personEmail);
    }
}
