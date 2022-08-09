package ru.bogdanov.SpringBootCrudAndJunit.letscode;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import ru.bogdanov.SpringBootCrudAndJunit.letscode.model.Car;
import ru.bogdanov.SpringBootCrudAndJunit.letscode.model.Role;
import ru.bogdanov.SpringBootCrudAndJunit.letscode.repository.CarRepository;
import ru.bogdanov.SpringBootCrudAndJunit.letscode.service.CarService;
import ru.bogdanov.SpringBootCrudAndJunit.letscode.service.MailSender;
import ru.bogdanov.SpringBootCrudAndJunit.letscode.service.PasswordEncoder;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class CarServiceImplTest {
    @Autowired
    private CarService carService;

    @MockBean
    private CarRepository carRepository;
    @MockBean
    private MailSender mailSender;
    @MockBean
    private PasswordEncoder passwordEncoder;

    @Test
    void addCar() {
        Car car = new Car();
        car.setEmail("some@mail.ru");

        boolean isCarCreated = carService.addCar(car);
        assertTrue(isCarCreated);

        assertNotNull(car.getActiveCode());
        assertTrue(CoreMatchers.is(car.getRoles()).matches(Collections.singleton(Role.USER)));

        verify(carRepository, times(1)).saveCar(car);
        verify(mailSender, times(1))
                .send(ArgumentMatchers.eq(car.getEmail()),
                        anyString(),
                        anyString());
    }

    @Test
    void addUserFailTest() {
        Car car = new Car();
        car.setName("Max");

        doReturn(new Car())
                .when(carRepository)
                .findByName("Max");

        boolean isCarCreated = carService.addCar(car);
        assertFalse(isCarCreated);

        verify(carRepository, times(0)).saveCar(ArgumentMatchers.any(Car.class));
        verify(mailSender, times(0))
                .send(anyString(),
                        anyString(),
                        anyString());
    }

    @Test
    void activeCarTest() {
        Car car = new Car();
        car.setActiveCode("bingo");

        doReturn(car)
                .when(carRepository)
                .findByActivateCode("activate");

        boolean activate = carService.activeCar("activate");

        assertTrue(activate);
        assertNull(car.getActiveCode());

        verify(carRepository, times(1)).saveCar(car);
    }

    @Test
    void activeCarTestFailTest() {
        boolean activate = carService.activeCar("activate me");
        assertFalse(activate);
        verify(carRepository, times(0)).saveCar(ArgumentMatchers.any(Car.class));
    }
}