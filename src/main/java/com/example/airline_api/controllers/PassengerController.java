package com.example.airline_api.controllers;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.PassengerRepository;
import com.example.airline_api.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/passengers")

public class PassengerController {

    @Autowired
    PassengerService passengerService;

    @Autowired
    PassengerRepository passengerRepository;

    // Display details of all passengers
    @GetMapping
    public ResponseEntity<List<Passenger>> getAllPassengers() {
     List<Passenger> passenger = passengerRepository.findAll();
     return new ResponseEntity<>(passenger, HttpStatus.OK);
    }

    // Display specific passenger details
    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Passenger>> getPassengerById(@PathVariable Long Id){
       return new ResponseEntity<>(passengerRepository.findById(Id.longValue()), HttpStatus.OK) ;
    }


    // Add a new passenger
    @PostMapping
    public ResponseEntity<Passenger> addNewPassenger(Passenger passenger) {
        passengerService.addNewPassenger(passenger);
        return new ResponseEntity<>(passenger,HttpStatus.OK);
    }

    // Delete a Passenger
    @DeleteMapping (value = "/{id}")
    public ResponseEntity<Long> cancelPassenger(@PathVariable Long id){
    passengerService.cancelPassenger(id);
    return new ResponseEntity<>(id,HttpStatus.OK);
    }


}