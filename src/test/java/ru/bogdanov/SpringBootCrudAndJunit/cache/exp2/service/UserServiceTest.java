package ru.bogdanov.SpringBootCrudAndJunit.cache.exp2.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import ru.bogdanov.SpringBootCrudAndJunit.cache.exm2.model.Order;
import ru.bogdanov.SpringBootCrudAndJunit.cache.exm2.service.OrderService;
import ru.bogdanov.SpringBootCrudAndJunit.cache.exp2.AbstractTest;

@Slf4j
public class UserServiceTest extends AbstractTest {
    @Autowired
    @Qualifier("TestService")
    private OrderService userService;

    @Test
    public void get() {
        Order user1 = userService.create(new Order("Vasya", "Vasya@mail.ru"));
        Order user2 = userService.create(new Order("Kolya", "Kolya@mail.ru"));

        getAndPrint(user1.getId());
        getAndPrint(user2.getId());
        getAndPrint(user1.getId());
        getAndPrint(user2.getId());
    }

    @Test
    public void create() {
        createAndPrint("Ivan", "ivan@mail.ru");
        createAndPrint("Ivan", "ivan1122@mail.ru");
        createAndPrint("Sergey", "sergey@mail.ru");

        log.info("all enters are below");
        userService.getAll().forEach(user -> log.info("{}", user.toString()));
    }

    @Test
    public void createAndRefresh() {
        Order order1 = userService.createOrReturnCached(new Order("Vasya", "vasya@mail.ru"));
        log.info("created Order1: {}", order1);

        Order order2 = userService.createOrReturnCached(new Order("Vasya", "misha@mail.ru"));
        log.info("created Order2: {}", order2);

        Order order3 = userService.createAndRefreshCache(new Order("Vasya", "kolya@mail.ru"));
        log.info("created Order3: {}", order3);

        Order order4 = userService.createOrReturnCached(new Order("Vasya", "petya@mail.ru"));
        log.info("created Order4: {}", order4);
    }

    @Test
    public void delete() {
        Order order1 = userService.create(new Order("Vasya", "vasya@mail.ru"));
        log.info("{}", userService.get(order1.getId()));

        Order order2 = userService.create(new Order("Vasya", "vasya@mail.ru"));
        log.info("{}", userService.get(order2.getId()));

        userService.delete(order1.getId());
        userService.deleteAndEvict(order2.getId());

        log.info("{}", userService.get(order1.getId()));
        log.info("{}", userService.get(order2.getId()));
    }

    private void getAndPrint(Long id) {
        log.info("User found: {}", userService.get(id));
    }

    private void createAndPrint(String name, String email) {
        log.info("created user: {}", userService.createWithNameAndEmail(name, email));
    }
}
