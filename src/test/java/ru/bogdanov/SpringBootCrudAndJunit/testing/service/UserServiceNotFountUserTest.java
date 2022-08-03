package ru.bogdanov.SpringBootCrudAndJunit.testing.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import ru.bogdanov.SpringBootCrudAndJunit.testing.model.User;
import ru.bogdanov.SpringBootCrudAndJunit.testing.repository.UserRepository;
import ru.bogdanov.SpringBootCrudAndJunit.testing.service.UserServiceImpl;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceNotFountUserTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    private final User user = User.builder().id(50L).name("Max Bogdanov").build();
    private final User newUser = User.builder().id(51L).name("Maxim Bogdanov").build();

    // Генерируем исключение, если пользователь не существует
    @Test(expected = RuntimeException.class)
    public void testUpdateUserIfNotFound() {
        given(userRepository.findById(anyLong())).willReturn(Optional.empty());
        userService.updateUser(user.getId(), newUser);
    }

    @Test(expected = RuntimeException.class)
    public void testDeleteUserIfNotFound() {
        given(userRepository.findById(anyLong())).willReturn(Optional.empty());
        userService.deleteUser(user.getId());
    }

    @Test(expected = RuntimeException.class)
    public void testGetUserByIdIfNotFount() {
        given(userRepository.findById(anyLong())).willReturn(Optional.empty());
        userService.getUserById(user.getId());
    }
}
