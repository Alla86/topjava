package ru.javawebinar.topjava;

import ru.javawebinar.topjava.matcher.ModelMatcher;
import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDateTime;
import java.util.Objects;

import static ru.javawebinar.topjava.model.BaseEntity.START_SEQ;

/**
 * GKislin
 * 13.03.2015.
 */
public class MealTestData {

    public static final int MEAL1_ID = START_SEQ;
    public static final int MEAL2_ID = START_SEQ+1;

    public static final Meal MEAL1 = new Meal(MEAL1_ID, LocalDateTime.now(), "Завтрак", 500);
    public static final Meal MEAL2 = new Meal(MEAL2_ID, LocalDateTime.now(), "Обед", 1000);


    public static final ModelMatcher<Meal> MATCHER = new ModelMatcher<>(
        (expected, actual) -> expected == actual ||
            (Objects.equals(expected.getCalories(), actual.getCalories())
            && Objects.equals(expected.getDescription(), actual.getDescription())
            && Objects.equals(expected.getDateTime(), actual.getDateTime())
            )
    );
}
