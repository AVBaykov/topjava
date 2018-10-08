package ru.javawebinar.topjava.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Meal {
    private final Integer ID;

    private final LocalDateTime dateTime;

    private final String description;

    private final int calories;

    public Meal(int ID, LocalDateTime dateTime, String description, int calories) {
        this.ID = ID;
        this.dateTime = dateTime;
        this.description = description;
        this.calories = calories;
    }

    public Meal(LocalDateTime dateTime, String description, int calories) {
        this(0, dateTime, description, calories);
    }

    public Meal(int id, Meal meal) {
        this.ID = id;
        this.dateTime = meal.dateTime;
        this.description = meal.description;
        this.calories = meal.calories;
    }

    public Meal() {
        this.ID = -1;
        this.dateTime = LocalDateTime.now().withSecond(0).withNano(0);
        this.description = "";
        this.calories = 0;
    }

    public int getID() {
        return ID;
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
