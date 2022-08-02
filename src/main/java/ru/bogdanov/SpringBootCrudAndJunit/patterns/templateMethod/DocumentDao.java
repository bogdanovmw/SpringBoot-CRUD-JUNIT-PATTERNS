package ru.bogdanov.SpringBootCrudAndJunit.patterns.templateMethod;

import org.springframework.stereotype.Component;

@Component
public class DocumentDao {
    public String getData() {
        return "data";
    }
}
