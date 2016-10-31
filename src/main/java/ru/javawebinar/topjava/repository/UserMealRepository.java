package ru.javawebinar.topjava.repository;

import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.model.User;

import java.time.LocalDateTime;
import java.util.Collection;

/**
 * GKislin
 * 06.03.2015.
 */
public interface UserMealRepository {
    UserMeal save(UserMeal meal, int userId);

    boolean delete(int id, int userId);

    UserMeal get(int id, int userId);

    Collection<UserMeal> getAll(int userId);

    Collection<UserMeal> getBetween(LocalDateTime startDateTime, LocalDateTime endDateTime, int userId);
}
