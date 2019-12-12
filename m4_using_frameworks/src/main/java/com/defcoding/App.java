package com.defcoding;

import com.defcoding.entities.Booking;
import com.defcoding.entities.Passenger;

import java.util.List;

public class App {


    public static void main(String[] args){

        new Booking("1234", List.of(new Passenger()), null);

    }
}
