package ru.javawebinar.topjava.service.datajpa;

import org.junit.Test;
import org.springframework.test.context.ActiveProfiles;
import ru.javawebinar.topjava.Profiles;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.service.AbstractUserServiceTest;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import static ru.javawebinar.topjava.MealTestData.MEALS;
import static ru.javawebinar.topjava.MealTestData.assertMatch;
import static ru.javawebinar.topjava.UserTestData.*;

@ActiveProfiles(Profiles.DATAJPA)
public class DataJpaUserRepositoryTest extends AbstractUserServiceTest {

    @Test
    public void getWithMeals() {
        User user = service.getWithMeals(USER_ID);
        assertMatchUser(user, USER);
        assertMatch(user.getMeals(), MEALS);
    }

    @Test
    public void getNotFoundWithMeals() {
        thrown.expect(NotFoundException.class);
        service.getWithMeals(NOT_EXIST_ID);
    }
}
