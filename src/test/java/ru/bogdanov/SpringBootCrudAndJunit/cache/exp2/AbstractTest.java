package ru.bogdanov.SpringBootCrudAndJunit.cache.exp2;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public abstract class AbstractTest {
    // Для создания одного контекста
    // Что бы не писать SpringBootTest над каждым тестом
}
