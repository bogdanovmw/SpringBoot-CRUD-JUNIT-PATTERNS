package ru.bogdanov.SpringBootCrudAndJunit.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long id) {
        super("User by id not found: " + id + ".");
    }
}
