package ru.bogdanov.SpringBootCrudAndJunit.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import ru.bogdanov.SpringBootCrudAndJunit.model.User;
import ru.bogdanov.SpringBootCrudAndJunit.service.UserServiceImpl;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserServiceImpl userService;

    private final User user = User.builder().id(1L).name("Max Bogdanov").build();

    @Test
    public void testCreateUserWhenPost() throws Exception {
        given(userService.createUser(user)).willReturn(user);

        mockMvc.perform(post("/api/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JsonUtil.toJson(user)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name", is(user.getName())));
    }

    @Test
    public void testUpdateUserWhenPut() throws Exception {
        given(userService.updateUser(user.getId(), user)).willReturn(user);

        ObjectMapper mapper = new ObjectMapper();

        mockMvc.perform(put("/api/users/" + user.getId().toString())
                    .content(mapper.writeValueAsString(user))
                    .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("name", is(user.getName())));
    }

    @Test
    public void testDeleteUserWhenDelete() throws Exception {
        doNothing().when(userService).deleteUser(user.getId());

        mockMvc.perform(delete("/api/users/" + user.getId())
                    .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }

    @Test
    public void testGetAllUsersWhenGet() throws Exception {
        List<User> users = Arrays.asList(user);

        given(userService.getAllUsers()).willReturn(users);

        mockMvc.perform(get("/api/users")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name", is(user.getName())));
    }

    @Test
    public void testGetUserByIdWhenGet() throws Exception {
        given(userService.getUserById(user.getId())).willReturn(user);

        mockMvc.perform(get("/api/users/" + user.getId())
                    .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("name", is(user.getName())));
    }
}
