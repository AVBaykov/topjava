package ru.javawebinar.topjava.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Meal {
    private final Integer id;

    private final LocalDateTime dateTime;

    private final String description;

    private final int calories;

    public Meal() {
        this(-1, LocalDateTime.now().withSecond(0).withNano(0), "", 0);
    }

    public Meal(int id, Meal meal) {
        this(id, meal.dateTime, meal.description, meal.calories);
    }

    public Meal(LocalDateTime dateTime, String description, int calories) {
        this(-1, dateTime, description, calories);
    }

    public Meal(int id, LocalDateTime dateTime, String description, int calories) {
        this.id = id;
        this.dateTime = dateTime;
        this.description = description;
        this.calories = calories;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getDescription() {
        return description;
    }

    public int getCalories() {
        return calories;
    }

    public LocalDate getDate() {
        return dateTime.toLocalDate();
    }

    public LocalTime getTime() {
        return dateTime.toLocalTime();
    }
}
