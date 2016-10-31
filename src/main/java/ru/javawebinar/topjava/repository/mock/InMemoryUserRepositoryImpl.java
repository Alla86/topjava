package ru.javawebinar.topjava.repository.mock;

import org.springframework.stereotype.Repository;
import ru.javawebinar.topjava.model.Role;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.repository.UserRepository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * GKislin
 * 15.06.2015.
 */
@Repository
public class InMemoryUserRepositoryImpl implements UserRepository {
    private Map<Integer, User> repository = new ConcurrentHashMap<>();
    private AtomicInteger counter = new AtomicInteger(0);
    //private static final Logger LOG = LoggerFactory.getLogger(InMemoryUserRepositoryImpl.class);

    public static final Comparator<User> USER_COMPARATOR = (u1, u2) -> u1.name.compareTo(u2.name);

    public static final int USER_ID = 1;
    public static final int ADMIN_ID = 2;

    {
        save(new User(1, "User", "user@yandex.ru", "password", Role.ROLE_USER));
        save(new User(2, "Admin", "admin@gmail.com", "admin", Role.ROLE_ADMIN));
    }

    @Override
    public User save(User user) {
        if (user.isNew()) {
            user.setId(counter.incrementAndGet());
        }
        return repository.put(user.getId(), user);
        //LOG.info("save " + user);
        //return user;
    }

    @Override
    public boolean delete(int id) { return repository.remove(id) != null; }

    @Override
    public User get(int id) { return repository.get(id);    }

    @Override
    public Collection<User> getAll() {
        //Collections.sort(Arrays.asList(repository.values()), (a, b) -> a.email.compareTo(b.email));
        //return Collections.sort(Arrays.asList(repository.values()), new UserComparator() );
        return repository.values().stream().sorted(USER_COMPARATOR).collect(Collectors.toList());
    }

    @Override
    public User getByEmail(String email) {
        return getAll().stream().filter(u -> u.getEmail().equals(email)).findFirst().orElse(null);
    }

    public class UserComparator implements Comparator<User> {
        @Override
        public int compare(User a, User b) {
            return a.name.compareTo(b.name);
        }
    }
}
