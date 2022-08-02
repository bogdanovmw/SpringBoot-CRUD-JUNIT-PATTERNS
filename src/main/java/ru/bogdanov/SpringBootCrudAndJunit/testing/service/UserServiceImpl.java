package ru.bogdanov.SpringBootCrudAndJunit.testing.service;

import org.springframework.stereotype.Service;
import ru.bogdanov.SpringBootCrudAndJunit.testing.exceptions.UserNotFoundException;
import ru.bogdanov.SpringBootCrudAndJunit.testing.model.User;
import ru.bogdanov.SpringBootCrudAndJunit.testing.repository.UserRepository;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long id, User user) {
        userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        user.setId(id);

        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        userRepository.deleteById(id);
    }
}
