package com.defcoding;

import com.defcoding.entities.Flight;
import com.defcoding.entities.FlightWithAnnotations;
import com.defcoding.entities.SearchRequest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.List;
import java.util.Set;

import static com.defcoding.FlightDateUtils.parseInputDate;
import static java.util.stream.Collectors.toList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FlightSearchServiceSearchResultTest {

    private final FlightSearchService searchService = getTestFlightSearchService();


    private static final String validFromDest = "Boston";
    private static final String validToDest = "New York";
    private static final String date = "15-10-2019";
    private static final String validPassengerNum = "2";

    @Test
    void searchFindsValidFlights(){

        List<Flight> flightsList = searchService.search(
                new SearchRequest(validPassengerNum, date, validFromDest, validToDest ));

        // JUnit way
        assertEquals(2, flightsList.size());

        // Hamcrest way
        assertThat(flightsList.size(), equalTo(2)); // v1 good
        assertThat(flightsList, hasSize(2)); // v2 - better, for collections
    }

    @Test
    void searchFindsValidFlightsWithCorrectDestinations(){

        List<Flight> flights = searchService.search(
                new SearchRequest(validPassengerNum, date, validFromDest, validToDest ));

        // 2 flights, both From Boston
        List<String> destinations = flights.stream().map(Flight::getFromDest).collect(toList());

        // JUnit way
        assertEquals("Boston", flights.get(0).getFromDest());
        assertEquals("Boston", flights.get(1).getFromDest());
        // more code if you have 3+ items

        // Hamcrest way
        assertThat(destinations, everyItem(equalTo("Boston")));
    }

    @Test
    void assertJSeparateDemo(){
        List<Flight> flights = searchService.search(
                new SearchRequest(validPassengerNum, date, validFromDest, validToDest ));


        Assertions.assertThat(flights)
                .isNotEmpty()
                .hasSize(2)
                .doesNotContainNull()
                .flatExtracting(Flight::getFromDest)
                .doesNotContain("Chicago")
                .allMatch(d -> d.equals("Boston"));
    }

    @Test
    void testWithSpring(){
        org.springframework.util.Assert.hasText("a","abc");
        org.springframework.util.Assert.isTrue(1 < 2);
        org.springframework.util.Assert.notEmpty(List.of("1"), "expected List to be empty");
        // etc..
    }

    @Test
    void testWithHibernate(){

        FlightWithAnnotations flight = new FlightWithAnnotations("", "", null, 10);

        // validate the input
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<FlightWithAnnotations>> violations = validator.validate(flight);
        assertEquals(4, violations.size());
    }



    private FlightSearchService getTestFlightSearchService() {
        return new FlightSearchService(new TestFlightStore());
    }

    public class TestFlightStore implements FlightStore {
        @Override
        public List<Flight> getFlights() {
            return List.of(
                    // date format DD-MM-YYYY
                    new Flight("Boston","New York",parseInputDate("15-10-2019"), 10),
                    new Flight("Boston","New York",parseInputDate("15-10-2019"), 7),
                    new Flight("Boston","New York",parseInputDate("16-10-2019"), 6),
                    new Flight("Boston","New York",parseInputDate("17-10-2019"), 1),


                    new Flight("New York","Boston",parseInputDate("18-10-2019"), 2),
                    new Flight("New York","Boston",parseInputDate("19-10-2019"), 2)
            );
        }
    }
}
