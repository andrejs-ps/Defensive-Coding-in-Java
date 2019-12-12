package com.defcoding;

import org.junit.jupiter.api.Test;

import static com.defcoding.FlightSearchService.flightSearch;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FlightSearchServiceNullAndEmptyStringTest {

    private static final FlightSearchService searchService = flightSearch();
    private static final String validFromDest = "Boston";
    private static final String validToDest = "Washington";
    private static final String date = "15/10/2019";
    private static final int validPassengerNum = 2;

    private static final String ERROR_MSG = "Expected to throw because null or empty string is not allowed, but it didn't";

    @Test
    void invalidDestinationFirstArgNotAllowed(){
        assertThrows(IllegalArgumentException.class,
                () -> searchService.search(null, validToDest, date, validPassengerNum),
                ERROR_MSG);

        assertThrows(IllegalArgumentException.class,
                () -> searchService.search("", validToDest, date, validPassengerNum),
                ERROR_MSG);

        assertThrows(IllegalArgumentException.class,
                () -> searchService.search(" ", validToDest, date, validPassengerNum),
                ERROR_MSG);

    }

    @Test
    void invalidDestinationSecondArgNotAllowed(){
        assertThrows(IllegalArgumentException.class,
                () -> searchService.search(validFromDest, null, date, validPassengerNum),
                ERROR_MSG);

        assertThrows(IllegalArgumentException.class,
                () -> searchService.search(validFromDest, "", date, validPassengerNum),
                ERROR_MSG);

        assertThrows(IllegalArgumentException.class,
                () -> searchService.search(validFromDest, " ", date, validPassengerNum),
                ERROR_MSG);
    }

    @Test
    void invalidDateNotAllowed(){
        assertThrows(IllegalArgumentException.class,
                () -> searchService.search(validFromDest, validToDest, null, validPassengerNum),
                ERROR_MSG);

        assertThrows(IllegalArgumentException.class,
                () -> searchService.search(validFromDest, validToDest, "", validPassengerNum),
                ERROR_MSG);

        assertThrows(IllegalArgumentException.class,
                () -> searchService.search(validFromDest, validToDest, "  ", validPassengerNum),
                ERROR_MSG);
    }


}
