package br.com.rafael.challenge.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class ParseDateUtil {

    public static LocalDateTime parseDateFromRequest(String date, LocalTime time) throws DateTimeParseException {
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate startDate = LocalDate.parse(date, pattern);
        return LocalDateTime.of(startDate, time);
    }

}
