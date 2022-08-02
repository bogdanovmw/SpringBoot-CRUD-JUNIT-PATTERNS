package ru.bogdanov.SpringBootCrudAndJunit.testing.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long id) {
        super("User by id not found: " + id + ".");
    }
}
