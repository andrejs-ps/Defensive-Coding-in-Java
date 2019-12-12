package com.defcoding.entities;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class FlightWithAnnotations {

    @NotNull
    @NotBlank
    private String fromDest;

    @NotNull
    @NotBlank
    private String toDest;

    @NotNull
    private LocalDate date;

    @Range(min = 1, max = 7)
    private int seatsAvailable;

    public FlightWithAnnotations(String fromDest,
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
