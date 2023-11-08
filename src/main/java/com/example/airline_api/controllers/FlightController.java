package com.example.airline_api.controllers;

import com.example.airline_api.models.Flight;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/flights")
public class FlightController {
@Autowired
FlightService flightService;

@Autowired
    FlightRepository flightRepository;

    // Display all available flights
    @GetMapping
    public ResponseEntity<List<Flight>> getAllFlights() {
        // this <List<Flight>> indicates the response body will be a list of flights
        List<Flight> flights = flightRepository.findAll();
        return new ResponseEntity<>(flights, HttpStatus.OK);
    }

    // Display a specific flight
    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Flight>>getFlightById(@PathVariable Long Id){
        return new ResponseEntity<>(flightRepository.findById(Id.longValue()), HttpStatus.OK) ;
    }

    // Add details of a new flight

    @PostMapping
    public ResponseEntity<Flight> addNewFlight(@RequestBody Flight flight){
        //@Request Body annotation is typically used with methods that handle HTTP POST requests
        // and are expecting the request body to contain data that should be converted into the parameter type.
        flightService.addFlight(flight);
        return new ResponseEntity<>(flight, HttpStatus.CREATED);
    }

    // Book passenger on a flight
    @PatchMapping(value = "/{id}")
    public ResponseEntity<Flight> addPassengerToFlight(){
        return null;
    }

    // Cancel flight
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Long> cancelFlight(@PathVariable Long id){
        flightService.cancelFlight(id);
        return new ResponseEntity<>(id,HttpStatus.OK);
    }

}
