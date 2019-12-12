package com.defcoding;

import com.defcoding.entities.SearchRequest;
import org.junit.jupiter.api.Test;

import static com.defcoding.FlightSearchService.flightSearch;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FlightSearchServicePassengerNumberTest {

    private static final FlightSearchService searchService = flightSearch();
    private static final String validFromDest = "Boston";
    private static final String validToDest = "Washington";
    private static final String date = "15-10-2019";

    @Test
    // no exception means passed test
    void onePassengerIsAllowed(){
        searchService.search(new SearchRequest("1", date, validFromDest, validToDest ));
    }

    @Test
    // no exception means passed test
    void sevenPassengersAreAllowed(){
        searchService.search(new SearchRequest("7", date, validFromDest, validToDest ));
    }

    @Test
    void zeroPassengersNotAllowed(){
        assertThrows(IllegalArgumentException.class,
                () -> searchService.search(new SearchRequest("0", date, validFromDest, validToDest )),
                "Expected to throw because zero passengers is an invalid value, but it didn't");
    }

    @Test
    void eightPassengersNotAllowed(){
        assertThrows(IllegalArgumentException.class,
                () -> searchService.search(new SearchRequest("8", date, validFromDest, validToDest )),
                "Expected to throw because eight passengers is not allowed, but it didn't");
    }


}
