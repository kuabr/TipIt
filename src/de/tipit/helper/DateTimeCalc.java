package de.tipit.helper;

import java.util.Date;

public class DateTimeCalc {

    private static final long MILLISECONDS_PER_SECOND = 1000L;

    private static final long MILLISECONDS_PER_MINUTE = MILLISECONDS_PER_SECOND * 60L;

    private static final long MILLISECONDS_PER_HOUR = MILLISECONDS_PER_MINUTE * 60L;

    private static final long MILLISECONDS_PER_DAY = MILLISECONDS_PER_HOUR * 24L;

    public static Date addDaysToDate(Date date, long days) {
        return new Date(date.getTime() + MILLISECONDS_PER_DAY * days);
    }
}
