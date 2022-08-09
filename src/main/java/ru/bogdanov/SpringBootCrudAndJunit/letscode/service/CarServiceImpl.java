package ru.bogdanov.SpringBootCrudAndJunit.letscode.service;

import org.springframework.stereotype.Service;
import ru.bogdanov.SpringBootCrudAndJunit.letscode.model.Car;
import ru.bogdanov.SpringBootCrudAndJunit.letscode.model.Role;
import ru.bogdanov.SpringBootCrudAndJunit.letscode.repository.CarRepository;

import java.util.Collections;

@Service
public class CarServiceImpl implements CarService {
    private CarRepository carRepository;
    private MailSender mailSender;

    public CarServiceImpl(CarRepository carRepository, MailSender mailSender) {
        this.carRepository = carRepository;
        this.mailSender = mailSender;
    }

    @Override
    public boolean addCar(Car car) {
        Car carFromDB = carRepository.findByName(car.getName());
        if (carFromDB != null) {
            return false;
        }

        car.setActiveCode("codeTrue");
        car.setEmail("some@mail.ru");
        car.setRoles(Collections.singleton(Role.USER));
        carRepository.saveCar(car);
        mailSender.send("some@mail.ru", "Activation code", "Message !!!");

        return true;
    }

    @Override
    public boolean activeCar(String code) {
        Car car = carRepository.findByActivateCode(code);
        if (car == null)
            return false;

        car.setActiveCode(null);
        carRepository.saveCar(car);

        return true;
    }

}
