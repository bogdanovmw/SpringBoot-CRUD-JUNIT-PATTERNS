package ru.bogdanov.SpringBootCrudAndJunit.service;

import ru.bogdanov.SpringBootCrudAndJunit.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(Long id);
    User createUser(User user);
    User updateUser(Long id, User user);
    void deleteUser(Long id);
}
