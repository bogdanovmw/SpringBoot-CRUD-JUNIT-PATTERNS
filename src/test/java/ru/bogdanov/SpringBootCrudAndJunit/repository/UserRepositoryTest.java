package ru.bogdanov.SpringBootCrudAndJunit.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import ru.bogdanov.SpringBootCrudAndJunit.model.User;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    @Order(1)
    @Rollback
    public void testCreateUser() {
        User user = new User();
        user.setName("Max Bogdanov");

        User savedUser = userRepository.save(user);
        assertThat(savedUser.getId()).isGreaterThan(0);
    }

    @Test
    @Order(2)
    public void testUpdateUser() {
        User user = userRepository.findById(9L).get();
        user.setName("Max Ivanov");

        User updatedUser = userRepository.save(user);
        assertThat(updatedUser.getName()).isEqualTo("Max Ivanov");
    }

    @Test
    @Order(3)
    public void deleteUser() {
        User user = userRepository.findById(9L).get();
        userRepository.deleteById(user.getId());

        User user1 = null;
        Optional<User> deletedUser = userRepository.findById(9L);
        if (deletedUser.isPresent()){
            user1 = deletedUser.get();
        }
        assertThat(user1).isNull();
    }

    @Test
    @Order(4)
    public void tesGetAllUsers() {
        List<User> users = userRepository.findAll();
        assertThat(users.size()).isGreaterThan(0);
    }

    @Test
    @Order(5)
    public void testGetUserById() {
        User user = userRepository.findById(9L).get();
        assertThat(user.getId()).isEqualTo(9L);
    }
}
