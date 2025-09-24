package com.example.usermanagement.controller;

import com.example.usermanagement.model.User;
import com.example.usermanagement.service.UserService;

import java.util.Optional;

public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public void createUser(String username, String email) {
        try {
            User user = userService.createUser(username, email);
            System.out.println("Utente creato con successo: " + user);
        } catch (Exception e) {
            System.err.println("Errore durante la creazione dell'utente: " + e.getMessage());
        }
    }

    public void findUser(Long id) {
        try {
            Optional<User> userOpt = userService.getUserById(id);
            userOpt.ifPresent(user -> System.out.println("Utente trovato: " + user));
            if (!userOpt.isPresent()) {
                System.out.println("Nessun utente trovato con ID: " + id);
            }
        } catch (Exception e) {
            System.err.println("Errore durante la ricerca dell'utente: " + e.getMessage());
        }
    }

    public void deleteUser(Long id) {
        try {
            userService.deleteUser(id);
            System.out.println("Utente con ID " + id + " eliminato con successo.");
        } catch (Exception e) {
            System.err.println("Errore durante l'eliminazione dell'utente: " + e.getMessage());
        }
    }
}
