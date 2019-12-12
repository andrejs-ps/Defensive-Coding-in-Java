package com.defcoding.entities;

import java.util.List;

import static java.util.Objects.requireNonNull;

public class Booking {

    private String referenceId;
    private List<Passenger> passengerList;
    private Flight flight;

    public Booking(String referenceId, List<Passenger> passengers, Flight flight){

        this.referenceId = isInvalidString(referenceId);
        this.passengerList = validateList(passengers);
        this.flight = requireNonNull(flight, "A booking cannot be created with a Flight null reference");
    }


    // you might to add forget validation
    // do you need this setter at all?
    // if not - remove it
    public void setReferenceId(String id){
        this.referenceId = id;
    }

    private List<Passenger> validateList(List<Passenger> passengers) {
        if( passengers == null || passengers.isEmpty()){
            throw new IllegalArgumentException("A list of passengers " +
                    "cannot be null and must contain at least one passenger");
        }
        return passengers;
    }

    private String isInvalidString(String s){
        if(s == null || s.trim().isEmpty()){
            throw new IllegalArgumentException("You have provided the following argument, but it cannot be null or empty:" + s);
        }
        return s;

    }
}
