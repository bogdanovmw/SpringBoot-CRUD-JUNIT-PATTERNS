package ru.bogdanov.SpringBootCrudAndJunit.letscode.model;

import lombok.Data;

import java.util.Set;

@Data
public class Car {
    private String id;
    private String name;
    private String age;
    private String activeCode;
    private Set<Role> roles;
    private String email;
}
