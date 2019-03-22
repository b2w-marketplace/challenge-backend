package com.hashicode.backend.utils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 *
 * Utilitário de datas
 *
 * @author takahashi
 */
public class DateUtils {

    public static LocalDate toLocalDate(String s){
        return LocalDateTime.ofInstant(Instant.parse(s), ZoneId.systemDefault()).toLocalDate();
    }

}
