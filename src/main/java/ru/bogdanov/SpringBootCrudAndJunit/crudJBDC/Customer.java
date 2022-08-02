package ru.bogdanov.SpringBootCrudAndJunit.crudJBDC;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "customer")
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String fio;
    private String phone;
    private String address;
    private LocalDateTime created;
}
