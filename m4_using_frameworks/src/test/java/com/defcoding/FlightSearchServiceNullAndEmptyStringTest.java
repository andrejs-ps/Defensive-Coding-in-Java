package com.defcoding;

import com.defcoding.entities.SearchRequest;
import org.junit.jupiter.api.Test;

import static com.defcoding.FlightSearchService.flightSearch;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FlightSearchServiceNullAndEmptyStringTest {

    private static final FlightSearchService searchService = flightSearch();
    private static final String validFromDest = "Boston";
    private static final String validToDest = "Washington";
    private static final String date = "15/10/2019";
    private static final String validPassengerNum = "2";

    private static final String ERROR_MSG = "Expected to throw because null or empty string is not allowed, but it didn't";

    @Test
    void invalidDestinationFirstArgNotAllowed(){

        assertThrows(IllegalArgumentException.class,
                () -> searchService.search(new SearchRequest(validPassengerNum, date, null, validToDest)));

        assertThrows(IllegalArgumentException.class,
                () -> searchService.search(new SearchRequest(validPassengerNum, date, "", validToDest)));

        assertThrows(IllegalArgumentException.class,
                () -> searchService.search(new SearchRequest(validPassengerNum, date, " ", validToDest)));
    }

    @Test
    void invalidDestinationSecondArgNotAllowed(){
        assertThrows(IllegalArgumentException.class,
                () -> searchService.search(new SearchRequest(validPassengerNum, date, validFromDest, null)));

        assertThrows(IllegalArgumentException.class,
                () -> searchService.search(new SearchRequest(validPassengerNum, date, validFromDest, "")));

        assertThrows(IllegalArgumentException.class,
                () -> searchService.search(new SearchRequest(validPassengerNum, date, validFromDest, " ")));

    }

    @Test
    void invalidDateNotAllowed(){
        assertThrows(IllegalArgumentException.class,
                () -> searchService.search(new SearchRequest(validPassengerNum, null, validFromDest, validToDest)));

        assertThrows(IllegalArgumentException.class,
                () -> searchService.search(new SearchRequest(validPassengerNum, "", validFromDest, validToDest)));

        assertThrows(IllegalArgumentException.class,
                () -> searchService.search(new SearchRequest(validPassengerNum, "1234", validFromDest, validToDest)));

    }


}
