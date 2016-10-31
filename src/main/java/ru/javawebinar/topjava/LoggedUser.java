package ru.javawebinar.topjava;

import ru.javawebinar.topjava.model.Role;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

/**
 * Created by Администратор on 30.10.16.
 */
public class LoggedUser {
    protected int id = 0;
    protected Set<Role> roles = Collections.singleton(Role.ROLE_USER);
    protected boolean enabled = true;

    private static LoggedUser LOGGED_USER = new LoggedUser();

    public static LoggedUser get() { return LOGGED_USER; }

    public static int id() { return get().id; }

    public Set<Role> getAuthorities() { return roles; }

    public boolean isEnabled() { return enabled; }
}
