package com.defcoding.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class SearchRequest {

    private int passengerNum;
    private String fromDestination;
    private String toDestination;
    private LocalDate departDate;


    public SearchRequest(String[] args) {
        if(args.length != 4) {throw new IllegalArgumentException("There should be exactly 4 arguments provided");}
        this.passengerNum = validatePassengerNum(args[0]);
        this.departDate = validateDate(args[1]);
        this.toDestination = isInvalidString(args[3]);
        this.fromDestination = isInvalidString(args[2]);

        if(fromDestination.equalsIgnoreCase(toDestination)){
            throw new IllegalArgumentException("From and To Destinations cannot be the same. You input " + fromDestination);
        }

    }

    private LocalDate validateDate(String stringDate) {
        String date = isInvalidString(stringDate);
        return parseInputDate(date);
    }

    private int validatePassengerNum(String inputPassengers) {
        int passengerNum = Integer.parseInt(inputPassengers);
        if(passengerNum < 1 || passengerNum > 7){
            throw new IllegalArgumentException("The number of passengers must be between 1 and 7");
        }
        return passengerNum;
    }

    public String getFromDestination() {
        return fromDestination;
    }

    public String getToDestination() {
        return toDestination;
    }

    public LocalDate getDepartureDate() {
        return departDate;
    }

    public int getPassengerNum() {
        return passengerNum;
    }


    private LocalDate parseInputDate(String departDate) {
        LocalDate date;

        try {
            date = LocalDate.parse(departDate, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        } catch (DateTimeParseException exception){
            // or display a user-friendly message on the UI
            throw new IllegalArgumentException(String.format("Could not parse input date %s, please input a date in format dd-MM-YYYY", departDate));
        }
        return date;
    }

    private String isInvalidString(String s){
        if(s == null || s.trim().isEmpty()){
            throw new IllegalArgumentException("You have provided the following argument, but it cannot be null or empty:" + s);
        }
        return s;

    }
}
