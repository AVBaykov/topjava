package ru.javawebinar.topjava.web.meal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.service.MealService;
import ru.javawebinar.topjava.to.MealWithExceed;
import ru.javawebinar.topjava.util.DateTimeUtil;
import ru.javawebinar.topjava.util.MealsUtil;
import ru.javawebinar.topjava.web.SecurityUtil;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static ru.javawebinar.topjava.web.SecurityUtil.getAuthUserId;

@Controller
public class MealRestController {
    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private MealService service;


    public List<MealWithExceed> getAllWithExceeded() {
        log.info("getAllWithExceed");
        return service.getAll(getAuthUserId(), SecurityUtil.authUserCaloriesPerDay());
    }

    public List<MealWithExceed> getFilteredWithExceeded(LocalDate startDate, LocalDate endDate, LocalTime startTime, LocalTime endTime) {
        LocalDate startD = startDate != null ? startDate : LocalDate.MIN;
        LocalDate endD = endDate != null ? endDate : LocalDate.MAX;
        LocalTime startT = startTime != null ? startTime : LocalTime.MIN;
        LocalTime endT = endTime != null ? endTime : LocalTime.MAX;

        return service.getFilteredWithExceed(getAuthUserId(), SecurityUtil.authUserCaloriesPerDay(), startD, endD, startT, endT);
    }

    public Meal get(int id) {
        log.info("get {}", id);
        return service.get(id, getAuthUserId());
    }

    public Meal create(Meal meal) {
        log.info("create {}", meal);
        return service.create(meal, getAuthUserId());
    }

    public void delete(int id) {
        log.info("delete {}", id);
        service.delete(id, getAuthUserId());
    }

    public void update(Meal meal) {
        log.info("update {} with id={} with userId={}", meal, meal.getId(), meal.getUserId());
        service.update(meal, getAuthUserId());
    }
}