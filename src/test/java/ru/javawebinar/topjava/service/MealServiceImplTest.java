package ru.javawebinar.topjava.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringRunner;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Fail.fail;
import static ru.javawebinar.topjava.MealTestData.*;
import static ru.javawebinar.topjava.UserTestData.ADMIN_ID;
import static ru.javawebinar.topjava.UserTestData.USER_ID;

@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringRunner.class)
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
public class MealServiceImplTest {

    @Autowired
    private MealService service;

    @Test
    public void create() {
        Meal newMeal = new Meal(LocalDateTime.now(), "new Meal", 1000);
        Meal created = service.create(newMeal, USER_ID);
        newMeal.setId(created.getId());
        assertMatch(created, newMeal);
    }

    @Test(expected = DataAccessException.class)
    public void duplicateUserDateTimeCreate() {
        service.create(new Meal(USER_100002.getDateTime(), "Bad desc", 10_000), USER_ID);
    }

    @Test
    public void get() {
        Meal meal = service.get(100002, USER_ID);
        assertMatch(meal, USER_100002);
    }

    @Test(expected = NotFoundException.class)
    public void getNotFound() {
        service.get(1, 1);
    }

    @Test(expected = NotFoundException.class)
    public void delete() {
        try {
            service.delete(100002, USER_ID);
        } catch (NotFoundException e) {
            fail("Trying to delete nonexistence meal");
        }
        service.get(100002, USER_ID);
    }

    @Test(expected = NotFoundException.class)
    public void deleteNotFound() {
        service.delete(1, 1);
    }

    @Test
    public void getBetweenDateTimes() {
        List<Meal> filtered = service.getBetweenDateTimes(USER_100003.getDateTime(), USER_100006.getDateTime(), USER_ID);
        assertMatch(filtered, USER_100006, USER_100005, USER_100004, USER_100003);
    }

    @Test
    public void getAll() {
        List<Meal> all = service.getAll(ADMIN_ID);
        assertMatch(all, ADMIN_100009, ADMIN_100008);
    }

    @Test
    public void update() {
        Meal updated = new Meal(USER_100002);
        updated.setDescription("Второй завтрак");
        updated.setCalories(1001);
        service.update(updated, USER_ID);
        assertMatch(service.get(100002, USER_ID), updated);
    }

    @Test(expected = NotFoundException.class)
    public void getForeign() {
        consistenceCheck(ADMIN_100008.getId(), ADMIN_ID);
        service.get(ADMIN_100008.getId(), USER_ID);
    }

    @Test(expected = NotFoundException.class)
    public void deleteForeign() {
        consistenceCheck(ADMIN_100008.getId(), ADMIN_ID);
        service.delete(ADMIN_100008.getId(), USER_ID);
    }

    @Test(expected = NotFoundException.class)
    public void updateForeign() {
        consistenceCheck(ADMIN_100008.getId(), ADMIN_ID);
        Meal updated = new Meal(ADMIN_100008);
        service.update(updated, USER_ID);
    }

    private void consistenceCheck(int id, int userId) {
        try {
            service.get(id, userId);
        } catch (NotFoundException e) {
            fail("Trying to get nonexistence meal");
        }
    }
}