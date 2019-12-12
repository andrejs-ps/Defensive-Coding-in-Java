package com.defcoding;

import com.defcoding.entities.Flight;

import java.util.List;

import static com.defcoding.FlightDateUtils.parseInputDate;

public class FlightStoreImpl implements FlightStore {

    public List<Flight> getFlights(){

        return List.of(
                // date format DD-MM-YYYY
                new Flight("Boston","New York", parseInputDate("15-10-2019"),50),
                new Flight("Boston","New York",parseInputDate("16-10-2019"),10),
                new Flight("Boston","New York",parseInputDate("17-10-2019"),1),


                new Flight("Boston","Washington",parseInputDate("15-10-2019"),20),
                new Flight("Boston","Washington",parseInputDate("16-10-2019"),7),
                new Flight("Boston","Washington",parseInputDate("17-10-2019"),1),


                new Flight("Boston","Atlanta",parseInputDate("16-10-2019"),3),
                new Flight("Boston","Atlanta",parseInputDate("17-10-2019"),2),


                new Flight("Boston","Chicago",parseInputDate("16-10-2019"),2),
                new Flight("Boston","Chicago",parseInputDate("17-10-2019"),1),


                new Flight("Chicago","New York",parseInputDate("17-10-2019"),5),
                new Flight("Atlanta","Boston",parseInputDate("18-10-2019"),3),


                new Flight("Washington","New York",parseInputDate("19-10-2019"),2),
                new Flight("Washington","Boston",parseInputDate("20-10-2019"),1),


                new Flight("New York","Boston",parseInputDate("18-10-2019"),2),
                new Flight("New York","Boston",parseInputDate("19-10-2019"),2)

        );

    }
}
