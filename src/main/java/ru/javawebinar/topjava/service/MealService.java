package ru.javawebinar.topjava.service;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.to.MealWithExceed;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.function.Predicate;

public interface MealService {

    Meal create(Meal meal, int userId);

    void delete(int id, int userId) throws NotFoundException;

    Meal get(int id, int userId) throws NotFoundException;

    void update(Meal meal, int userId);

    List<MealWithExceed> getAll(int userId, int caloriesPerDay);

    List<MealWithExceed> getFilteredWithExceed(int userId,
                                               int caloriesPerDay,
                                               LocalDate startDate,
                                               LocalDate endDate, LocalTime startTime,
                                               LocalTime endTime);
}