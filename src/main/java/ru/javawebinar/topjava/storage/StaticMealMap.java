package ru.javawebinar.topjava.storage;

import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDateTime;
import java.time.Month;

public class StaticMealMap {

    private static MapMealStorage mealStorage = new MapMealStorage();

    static {
        mealStorage.save(new Meal(-1, LocalDateTime.of(2015, Month.MAY, 30, 10, 0), "Завтрак", 500));
        mealStorage.save(new Meal(-1, LocalDateTime.of(2015, Month.MAY, 30, 13, 0), "Обед", 1000));
        mealStorage.save(new Meal(-1, LocalDateTime.of(2015, Month.MAY, 30, 20, 0), "Ужин", 500));
        mealStorage.save(new Meal(-1, LocalDateTime.of(2015, Month.MAY, 31, 10, 0), "Завтрак", 1000));
        mealStorage.save(new Meal(-1, LocalDateTime.of(2015, Month.MAY, 31, 13, 0), "Обед", 500));
        mealStorage.save(new Meal(-1, LocalDateTime.of(2015, Month.MAY, 31, 20, 0), "Ужин", 510));
    }

    public static MapMealStorage getMealStorage() {
        return mealStorage;
    }
}
