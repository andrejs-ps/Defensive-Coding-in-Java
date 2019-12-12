package com.defcoding.entities;

import java.time.LocalDate;

public class Flight {

    private String fromDest;
    private String toDest;
    private LocalDate date;
    private int seatsAvailable;

    public Flight(String fromDest,
                  String toDest,
                  LocalDate date,
                  int seatsAvailable){
        this.fromDest = fromDest;
        this.toDest = toDest;
        this.date = date;
        this.seatsAvailable = seatsAvailable;
    }

    public String getFromDest() {
        return fromDest;
    }

    public String getToDest() {
        return toDest;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getSeatsAvailable() {
        return seatsAvailable;
    }

    @Override
    public String toString(){
        return String.format("From %s to %s. Date: %s. Available seats left: %s", fromDest, toDest, date, seatsAvailable);
    }
}
