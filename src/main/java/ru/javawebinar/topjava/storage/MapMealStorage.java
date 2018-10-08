package ru.javawebinar.topjava.storage;

import ru.javawebinar.topjava.model.Meal;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class MapMealStorage implements MealStorage {

    private static AtomicInteger counter = new AtomicInteger(0);

    private Map<Integer, Meal> mealMap = new ConcurrentHashMap<>();


    @Override
    public void update(Meal meal) {
        mealMap.put(meal.getId(), meal);
    }

    @Override
    public void save(Meal meal) {
        int id = counter.getAndIncrement();
        mealMap.put(id, new Meal(id, meal));
    }

    @Override
    public Meal get(Integer id) {
        return mealMap.get(id);
    }

    @Override
    public void delete(Integer id) {
        mealMap.remove(id);
    }

    @Override
    public List<Meal> getAll() {
        return new ArrayList<>(mealMap.values());
    }
}
