package ru.bogdanov.SpringBootCrudAndJunit.cache.exp2.config;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import ru.bogdanov.SpringBootCrudAndJunit.cache.exm2.model.Order;
import ru.bogdanov.SpringBootCrudAndJunit.cache.exm2.service.OrderService;
import ru.bogdanov.SpringBootCrudAndJunit.cache.exp2.AbstractTest;

@Slf4j
public class CacheConfigTest extends AbstractTest {
    @Autowired
    @Qualifier("TestService")
    private OrderService userService;

    @Test
    public void checkSettings() throws InterruptedException {
        Order order1 = userService.createOrReturnCached(new Order("Vasya", "vasya@mail.ru"));
        log.info("{}", userService.get(order1.getId()));

        Order order2 = userService.createOrReturnCached(new Order("Vasya", "vasya@mail.ru"));
        log.info("{}", userService.get(order2.getId()));

        Thread.sleep(1000L);
        Order order3 = userService.createOrReturnCached(new Order("Vasya", "vasya@mail.ru"));
        log.info("{}", userService.get(order3.getId()));
    }
}
