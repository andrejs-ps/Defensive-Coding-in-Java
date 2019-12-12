package com.defcoding;

import org.junit.jupiter.api.Test;

import static com.defcoding.FlightSearchService.flightSearch;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FlightSearchServicePassengerNumberTest {

    private static final FlightSearchService searchService = flightSearch();
    private static final String validFromDest = "Boston";
    private static final String validToDest = "Washington";
    private static final String date = "15-10-2019";
    private static final int validPassengerNum = 2;

    @Test
    // no exception means passed test
    void onePassengerIsAllowed(){
        searchService.search(validFromDest, validToDest, date, 1);
    }

    @Test
    // no exception means passed test
    void sevenPassengersAreAllowed(){
        searchService.search(validFromDest, validToDest, date, 7);
    }

    @Test
    void zeroPassengersNotAllowed(){
        assertThrows(IllegalArgumentException.class,
                () -> searchService.search(validFromDest, validToDest, date, 0),
                "Expected to throw because zero passengers is an invalid value, but it didn't");
    }

    @Test
    void eightPassengersNotAllowed(){
        assertThrows(IllegalArgumentException.class,
                () -> searchService.search(validFromDest, validToDest, date, 8),
                "Expected to throw because eight passengers is not allowed, but it didn't");
    }


}
