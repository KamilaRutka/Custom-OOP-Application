package com.example.carrent.controller;

import com.example.carrent.dto.RentDTO;
import com.example.carrent.model.Car;
import com.example.carrent.model.Rent;
import com.example.carrent.service.RentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@AllArgsConstructor
class RentController {

    private RentService rentService;

    @PostMapping("/rent")
    public ResponseEntity addNewRent(@RequestBody RentDTO rentDTO) {

        rentService.addNewRent(rentDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/rent")
    public ResponseEntity<List<Rent>> getRent() {
        return ResponseEntity.ok(rentService.getRents());
    }

    @DeleteMapping("/rent/{id}")
    public ResponseEntity deleteRent(@PathVariable Long id) {
        rentService.deleteRent(id);
        return ResponseEntity.ok().build();
    }
}
