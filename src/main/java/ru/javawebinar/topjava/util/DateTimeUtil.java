package ru.javawebinar.topjava.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtil {
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm");

    public static <V extends Comparable<V>> boolean isBetween(V value, V startValue, V endValue) {
        return value.compareTo(startValue) >= 0 && value.compareTo(endValue) <= 0;
    }

    public static LocalDate toDate(String string) {
        if (string.isEmpty()) {
            return null;
        } else {
            return LocalDate.parse(string, DATE_FORMATTER);
        }
    }

    public static LocalTime toTime(String string) {
        if (string.isEmpty()) {
            return null;
        } else {
            return LocalTime.parse(string, TIME_FORMATTER);
        }
    }

    public static String toString(LocalDateTime ldt) {
        return ldt == null ? "" : ldt.format(DATE_TIME_FORMATTER);
    }
}
