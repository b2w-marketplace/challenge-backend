package com.hashicode.backend.utils;

import java.time.*;
import java.time.temporal.ChronoUnit;

/**
 *
 * Utilitário de datas
 *
 * @author takahashi
 */
public class DateUtils {

    public static LocalDate toLocalDate(String s){
        return ZonedDateTime.parse(s).truncatedTo(ChronoUnit.DAYS).toLocalDate();
    }

}
