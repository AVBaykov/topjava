package ru.javawebinar.topjava.storage;

import ru.javawebinar.topjava.model.Meal;

import java.util.List;

public interface MealStorage {

    void clear();

    void update(Integer id, Meal meal);

    void save(Meal meal);

    Meal get(Integer id);

    void delete(Integer id);

    List<Meal> getAllMeals();

    int size();
}
