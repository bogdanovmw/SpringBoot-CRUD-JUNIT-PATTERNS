package ru.bogdanov.SpringBootCrudAndJunit.patterns.chainOfResponsibility.model;

import lombok.Getter;
import lombok.ToString;

import java.util.Collections;
import java.util.List;

@Getter
@ToString(exclude = "products")
public class Order {
    private final String id;
    private final String fio;
    private final String address;
    private final String phoneNumber;
    private final List<Product> products;
    private final boolean smsNotification;

    public Order(String id, String fio, String address, String phoneNumber, List<Product> products, boolean smsNotification) {
        this.id = id;
        this.fio = fio;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.products = Collections.unmodifiableList(products);
        this.smsNotification = smsNotification;
    }
}
