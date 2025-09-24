package com.example.usermanagement.service;

import com.example.usermanagement.exception.UserAlreadyExistsException;
import com.example.usermanagement.exception.UserNotFoundException;
import com.example.usermanagement.model.User;
import com.example.usermanagement.repository.UserRepository;

import java.util.Optional;

public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(String username, String email) {
        if (username == null || username.trim().isEmpty() || email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Username e email non possono essere vuoti.");
        }

        if (!email.contains("@")) {
            throw new IllegalArgumentException("Formato email non valido.");
        }

        userRepository.findByUsername(username).ifPresent(u -> {
            throw new UserAlreadyExistsException("Un utente con username '" + username + "' esiste già.");
        });

        User user = new User(username, email);
        return userRepository.save(user);
    }

    public Optional<User> getUserById(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("L'ID utente non può essere nullo o negativo.");
        }
        return userRepository.findById(id);
    }

    public void deleteUser(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("L'ID utente non può essere nullo o negativo.");
        }
        
        userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Utente non trovato con ID: " + id));
        
        userRepository.deleteById(id);
    }
}
