package ru.bogdanov.SpringBootCrudAndJunit.testing.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import ru.bogdanov.SpringBootCrudAndJunit.testing.model.User;
import ru.bogdanov.SpringBootCrudAndJunit.testing.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    private final User user = User.builder().id(50L).name("Max Bogdanov").build();
    private final User newUser = User.builder().id(51L).name("Maxim Bogdanov").build();

    @Test
    public void testCreateUser() {
        when(userRepository.save(ArgumentMatchers.any(User.class))).thenReturn(user);

        User created = userService.createUser(user);
        assertThat(created.getName()).isSameAs(user.getName());

        verify(userRepository).save(user);
    }

    @Test
    public void testUpdateUserIfFound() {
        given(userRepository.findById(user.getId())).willReturn(Optional.of(user));

        userService.updateUser(this.user.getId(), newUser);

        verify(userRepository).findById(this.user.getId());
        verify(userRepository).save(newUser);
    }

    @Test
    public void testDeleteUserIfFound() {
        when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));

        userService.deleteUser(user.getId());

        verify(userRepository).deleteById(user.getId());
    }

    @Test
    public void testGetAllUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User());

        given(userRepository.findAll()).willReturn(users);

        List<User> expected = userService.getAllUsers();
        assertEquals(expected, users);

        verify(userRepository).findAll();
    }

    @Test
    public void testGetUserByIdIfFound() {
        when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));

        User expected = userService.getUserById(user.getId());

        assertThat(expected).isSameAs(user);

        verify(userRepository).findById(user.getId());
    }
}
