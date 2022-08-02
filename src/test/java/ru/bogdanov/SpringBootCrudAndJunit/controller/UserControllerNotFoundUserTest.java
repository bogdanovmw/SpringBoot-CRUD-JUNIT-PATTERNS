package ru.bogdanov.SpringBootCrudAndJunit.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import ru.bogdanov.SpringBootCrudAndJunit.testing.controller.UserController;
import ru.bogdanov.SpringBootCrudAndJunit.testing.exceptions.UserNotFoundException;
import ru.bogdanov.SpringBootCrudAndJunit.testing.model.User;
import ru.bogdanov.SpringBootCrudAndJunit.testing.service.UserServiceImpl;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerNotFoundUserTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserServiceImpl userService;

    private final User user = User.builder().id(1L).name("Max Bogdanov").build();
    private final ObjectMapper mapper = new ObjectMapper();

    @Test
    public void shouldThrowExceptionWhenUserUpdateNotFound() throws Exception {
        Mockito.doThrow(new UserNotFoundException(user.getId())).when(userService).updateUser(user.getId(), user);

        mockMvc.perform(put("/api/users/" + user.getId())
                        .content(mapper.writeValueAsString(user))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    public void shouldThrowExceptionWhenUserDeleteNotFound() throws Exception {
        Mockito.doThrow(new UserNotFoundException(user.getId())).when(userService).deleteUser(user.getId());

        mockMvc.perform(delete("/api/delete/" + user.getId())
                    .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    public void shouldThrowExceptionWhenGetUserByIdNotFound() throws Exception {
        Mockito.doThrow(new UserNotFoundException(user.getId())).when(userService).getUserById(user.getId());

        mockMvc.perform(get("/api/users/" + user.getId())
                    .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
}
