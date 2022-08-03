package ru.bogdanov.SpringBootCrudAndJunit.cache.exm2.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    public Order(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
