package com.defcoding;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateUtils {

    public static LocalDate parseInputDate(String departDate) {
        LocalDate date;

        try {
            date = LocalDate.parse(departDate, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        } catch (DateTimeParseException exception){
            // or display a user-friendly message on the UI
            throw new IllegalArgumentException(String.format("Could not parse input date %s, please input a date in format dd-MM-YYYY", departDate));
        }
        return date;
    }
}
