package com.defcoding;


import com.defcoding.entities.Flight;
import com.defcoding.entities.SearchRequest;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class FlightSearchService {

    private FlightStore flightStore;


    public FlightSearchService(FlightStore store){
        this.flightStore = store;
    }

    public List<Flight> search(SearchRequest request){
        List<Flight> flights = flightStore.getFlights();

        return flights.stream()
                .filter(f -> f.getFromDest().equals(request.getFromDestination()))
                .filter(f -> f.getToDest().equals(request.getToDestination()))
                .filter(f -> f.getDate().equals(request.getDepartureDate()))
                .filter(f -> f.getSeatsAvailable() >= request.getPassengerNum())
                .collect(toList());
    }



    public static FlightSearchService flightSearch(){
        return new FlightSearchService(new FlightStoreImpl());
    }


}
