package com.example.airline_api.service;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //listen out to service
public class PassengerService {

    @Autowired
    PassengerRepository passengerRepository;
//Autowired is telling the Spring(inversion of control) to inject an instance of the 'PassengerRepository'
// bean into the 'passengerRepository' field.
//PassengerRepository is an interface that extends 'JPARepository'. To be able to interact with the database to do CRUD

    @Autowired
    FlightRepository flightRepository;


    public void addNewPassenger(Passenger passenger) {
        passengerRepository.save(passenger);
    }

    public List<Passenger> getAllPassengers(Passenger passenger) {
        return passengerRepository.findAll();
    }

    public Passenger findPassengerById(Long id) {
        return passengerRepository.findById(id).get();
    }

    public void cancelPassenger(long id) {
        passengerRepository.deleteById(id);
    }

    public void bookPassenger(long flightId, long passengerId) {
        Passenger passenger = passengerRepository.findById(passengerId).get();
        Flight flight = flightRepository.findById(flightId).get();
        if (flight.getPassengers().size() < flight.getCapacity()) {
            flight.addPassenger(passenger);
            passengerRepository.save(passenger);
        }
    }

}
