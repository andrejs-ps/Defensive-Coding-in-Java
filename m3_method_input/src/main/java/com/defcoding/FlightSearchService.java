package com.defcoding;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

import static java.time.format.DateTimeFormatter.ofPattern;
import static java.util.stream.Collectors.toList;

public class FlightSearchService {

    private FlightStore flightStore;


    public FlightSearchService(FlightStore store){
        this.flightStore = store;
    }

    public List<Flight> search(String fromDest, String toDest, String departDate, int passengerNum){
        List<Flight> flights = flightStore.getFlights();

        if(isInvalidString(fromDest) || isInvalidString(toDest)  || isInvalidString(departDate)) {

            String msg = String.format("You have provided the following arguments, none of them can be null. " +
                    "fromDest: %s, toDest: %s, date: %s", fromDest, toDest, departDate);
            throw new IllegalArgumentException(msg);
        }

        if(fromDest.equalsIgnoreCase(toDest)){
            throw new IllegalArgumentException("From and To Destinations cannot be the same. " +
                    "You input " + fromDest);
        }

        if(passengerNum < 1 || passengerNum > 7){
            throw new IllegalArgumentException("The number of passengers must be between 1 and 7");
        }

        LocalDate date = parseInputDate(departDate);

        return flights.stream()
                .filter(f -> f.getFromDest().equals(fromDest))
                .filter(f -> f.getToDest().equals(toDest))
                // not null safe - if retrieved date is null
                // then date.equals() will cause a NullPointerException
                .filter(f -> date.equals(LocalDate.parse(f.getDate(), ofPattern("dd-MM-yyyy"))))
                .filter(f -> f.getSeatsAvailable() >= passengerNum)
                .collect(toList());
    }



    private LocalDate parseInputDate(String departDate) {
        LocalDate date;

        try {
            date = LocalDate.parse(departDate, ofPattern("dd-MM-yyyy"));
        } catch (DateTimeParseException e){
            String msg = String.format("Could not parse input date '%s', expected format is dd-MM-yyyy", departDate);
            throw new IllegalArgumentException(msg, e);
        }
        return date;
    }

    private boolean isInvalidString(String s){
        return s == null || s.trim().isEmpty();
    }

    public static FlightSearchService flightSearch(){
        return new FlightSearchService(new FlightStoreImpl());
    }


}
