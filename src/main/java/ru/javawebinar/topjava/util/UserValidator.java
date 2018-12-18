package ru.javawebinar.topjava.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.javawebinar.topjava.AuthorizedUser;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.repository.UserRepository;
import ru.javawebinar.topjava.to.UserTo;
import ru.javawebinar.topjava.web.SecurityUtil;

@Component
public class UserValidator implements Validator {

    @Autowired
    UserRepository userRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return UserTo.class.equals(clazz) || User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user;
        AuthorizedUser auth = SecurityUtil.safeGet();

        if (target instanceof UserTo) {
            UserTo targetUser = (UserTo) target;
            user = userRepository.getByEmail(targetUser.getEmail());

            if (user != null) {
                if (auth == null || !user.getId().equals(auth.getId())) {
                    reject(errors);
                }
            }
        } else if (target instanceof User) {
            User targetUser = (User) target;
            user = userRepository.getByEmail(targetUser.getEmail());

            if (user != null && !user.getId().equals(targetUser.getId())) {
                reject(errors);
            }
        }
    }

    private static void reject(Errors errors) {
        errors.rejectValue("email", "common.duplicate.user.email", "User with this email already exists");
    }
}
