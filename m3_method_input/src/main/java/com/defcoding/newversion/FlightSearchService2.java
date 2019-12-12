package com.defcoding.newversion;

import com.defcoding.Flight;
import com.defcoding.FlightStore;
import com.defcoding.FlightStoreImpl;
import com.defcoding.entities.SearchRequest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class FlightSearchService2 {

    private FlightStore flightStore;


    public FlightSearchService2(FlightStore store){
        this.flightStore = store;
    }

    public List<Flight> search(SearchRequest request){
        List<Flight> flights = flightStore.getFlights();

        // I have the guarantee that the request object contains
        // valid values only!

        return flights.stream()
                .filter(f -> f.getFromDest().equals(request.getFromDestination()))
                .filter(f -> f.getToDest().equals(request.getToDestination()))
                .filter(f -> LocalDate.parse(f.getDate(), DateTimeFormatter.ofPattern("dd-MM-yyyy")).equals(request.getDepartureDate()))
//                .filter(f -> f.getDate().equals(parsedDate))
                .filter(f -> f.getSeatsAvailable() >= request.getPassengerNum())
                .collect(toList());
    }



    public static FlightSearchService2 flightSearch(){
        return new FlightSearchService2(new FlightStoreImpl());
    }


}
