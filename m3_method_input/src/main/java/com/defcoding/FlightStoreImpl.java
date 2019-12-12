package com.defcoding;

import java.util.List;

public class FlightStoreImpl implements FlightStore {

    public List<Flight> getFlights(){

        return List.of(
                // date format DD-MM-YYYY
                new Flight("Boston","New York","15-10-2019",50),
                new Flight("Boston","New York","16-10-2019",10),
                new Flight("Boston","New York","17-10-2019",1),


                new Flight("Boston","Washington","15-10-2019",20),
                new Flight("Boston","Washington","16-10-2019",7),
                new Flight("Boston","Washington","17-10-2019",1),


                new Flight("Boston","Atlanta","16-10-2019",3),
                new Flight("Boston","Atlanta","17-10-2019",2),


                new Flight("Boston","Chicago","16-10-2019",2),
                new Flight("Boston","Chicago","17-10-2019",1),


                new Flight("Chicago","New York","17-10-2019",5),
                new Flight("Atlanta","Boston","18-10-2019",3),


                new Flight("Washington","New York","19-10-2019",2),
                new Flight("Washington","Boston","20-10-2019",1),


                new Flight("New York","Boston","18-10-2019",2),
                new Flight("New York","Boston","19-10-2019",2)

        );

    }
}
