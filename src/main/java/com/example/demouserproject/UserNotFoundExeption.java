package com.example.demouserproject;

import java.util.UUID;

public class UserNotFoundExeption extends RuntimeException {
    public UserNotFoundExeption(UUID id) {
        super("Could not find user with provided id: " + id);
    }
}
