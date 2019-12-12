package com.defcoding.newversion;

import com.defcoding.Flight;
import com.defcoding.entities.SearchRequest;

import java.util.Arrays;
import java.util.List;

import static com.defcoding.newversion.FlightSearchService2.flightSearch;

public class App2 {


    public static void main(String[] args){

        SearchRequest request = new SearchRequest(args);


        FlightSearchService2 searchService = flightSearch();

        List<Flight> outboundFlights = searchService.search(request);

        displayFlights(outboundFlights);







//        toDestination = null;
//        System.out.println("Number of passengers: " + passengerNum);
//        System.out.println("From date: " + departDate);
//        System.out.println("To date: " + returnDate);
//        System.out.println("Flying from: " + fromDestination);
//        System.out.println("Flying to: " + toDestination);

    }

    private static void displayFlights(List<Flight> outboundFlights) {
        if(outboundFlights.size() == 0){
            System.out.println("No flights found for your search criteria.");
        } else {
            System.out.println("Flights found:");
            System.out.println(Arrays.toString(outboundFlights.toArray()));
        }
    }
}
