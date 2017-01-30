package br.com.munieri.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static final String SIMPLE_PATTERN = "dd-MM-yyyy";
    public static final String CREATION_PATTERN = "yyyy-MM-dd";
    public static final String COMPLETE_PATTERN = "yyyy-MM-dd'T'kk:mm:ss.S";

    public static Date parse(String date, String pattern) throws ParseException {

        DateFormat format = new SimpleDateFormat(pattern);

        return format.parse(date);
    }

    public static String format(Date date, String pattern) {

        DateFormat format = new SimpleDateFormat(pattern);

        return format.format(date);
    }

    public static String format(Date date) {

        DateFormat format = new SimpleDateFormat(COMPLETE_PATTERN);

        return format.format(date);
    }
}
