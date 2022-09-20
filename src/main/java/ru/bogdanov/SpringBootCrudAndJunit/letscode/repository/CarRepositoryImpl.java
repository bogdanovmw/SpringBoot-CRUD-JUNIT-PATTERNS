package ru.bogdanov.SpringBootCrudAndJunit.letscode.repository;

import org.springframework.stereotype.Repository;
import ru.bogdanov.SpringBootCrudAndJunit.letscode.model.Car;

@Repository
public class CarRepositoryImpl implements CarRepository {
    @Override
    public boolean saveCar(Car car) {
        System.out.println("Car save successfully!");
        return true;
    }

    @Override
    public Car findByName(String name) {
        return new Car();
    }

    @Override
    public Car findByActivateCode(String code) {
        return new Car();
    }
}
