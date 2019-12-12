package com.defcoding;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static com.defcoding.DateUtils.parseInputDate;
import static java.time.temporal.ChronoUnit.DAYS;
import static java.util.Comparator.comparing;

public class OptionalDemo {

    public static void main(String[] args){

        List<Flight> flightList = getFlights();

        // get me the earliest flight
        Optional<Flight> earliestFlight =
                flightList.stream()
                    .filter(f -> "Boston".equals(f.getFromDest()))
                    .filter(f -> "San Francisco".equals(f.getToDest()))
                    .min(comparing(Flight::getDate));


        // Will fail with a NoSuchElementException if Optional is empty and you use .get()
        // System.out.println("Earliest flight date: " + earliestFlight.get().getDate());


        // so instead use one of these options

        // (1)
        System.out.println(earliestFlight
                                .orElse(new Flight("Boston", "San Jose", LocalDate.now().plus(1, DAYS), 2)));



        // (2)
        earliestFlight.ifPresentOrElse(
                        x -> System.out.println("Flight found: " + earliestFlight),
                        () -> System.out.println("Didn't find any flights for your search"));


        // (3)
        Flight foundFlight = earliestFlight.orElseThrow(NoFlightAvailable::new);

    }

    private static List<Flight> getFlights(){
        return List.of(
                // date format DD-MM-YYYY
                new Flight("Boston","New York",parseInputDate("17-10-2019"), 1, PlaneModel.AIRBUS_320),
                new Flight("Boston","New York",parseInputDate("15-10-2019"), 10, PlaneModel.BOEING737_700),
                new Flight("Boston","New York",parseInputDate("16-10-2019"), 6, null),
                new Flight("Boston","New York",parseInputDate("15-10-2019"), 7, PlaneModel.BOEING737_800),


                new Flight("New York","Boston",parseInputDate("18-10-2019"), 2, PlaneModel.AIRBUS_320),
                new Flight("New York","Boston",parseInputDate("19-10-2019"), 2, null)
        );
    }

    private static class NoFlightAvailable extends RuntimeException {
    }
}
