package ru.bogdanov.SpringBootCrudAndJunit.letscode.model;

import lombok.Data;

@Data
public class Message {
    private String emailTo;
    private String subject;
    private String message;
}
