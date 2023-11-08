package com.example.airline_api.components;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerRepository passengerRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        //Flights Europe
        //One
        Flight flightOne = new Flight(
                "Ghana",
                5,
                "November-10",
                "20:00"
        );
        flightRepository.save(flightOne);

        //Two
        Flight flightTwo = new Flight(
                "Trindad",
                120,
                "November-16",
                "2100"
        );
        flightRepository.save(flightTwo);

        //Three
        Flight flightThree = new Flight(
                "Peru",
                10,
                "November-13",
                "1800"
        );
        flightRepository.save(flightThree);


        //Passengers
        //One
        Passenger Janet = new Passenger(
                "John",
                "John@mail"
        );
        passengerRepository.save(Janet);

        //Two
        Passenger Derulo = new Passenger(
                "Jason",
                "Jason@mail"
        );
        passengerRepository.save(Derulo);

        //Three
        Passenger James = new Passenger(
                "James",
                "James@mail"
        );
        passengerRepository.save(James);

    }
}
