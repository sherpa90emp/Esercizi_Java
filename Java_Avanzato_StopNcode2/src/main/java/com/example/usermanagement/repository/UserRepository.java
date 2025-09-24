package com.example.usermanagement.repository;

import com.example.usermanagement.model.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

public class UserRepository {

    private final Map<Long, User> userStore = new HashMap<>();
    private final AtomicLong idCounter = new AtomicLong();

    public User save(User user) {
        if (user.getId() == null) {
            long newId = idCounter.incrementAndGet();
            user.setId(newId);
            userStore.put(newId, user);
            return new User(newId, user.getUsername(), user.getEmail());
        }
        userStore.put(user.getId(), user);
        return user;
    }

    public Optional<User> findById(Long id) {
        return Optional.ofNullable(userStore.get(id));
    }

    public Optional<User> findByUsername(String username) {
        return userStore.values().stream()
                .filter(user -> user.getUsername().equalsIgnoreCase(username))
                .findFirst();
    }

    public void deleteById(Long id) {
        userStore.remove(id);
    }
    
    public void deleteAll() {
        userStore.clear();
    }
}
