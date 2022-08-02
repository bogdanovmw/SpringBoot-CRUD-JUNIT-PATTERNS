package ru.bogdanov.SpringBootCrudAndJunit.patterns.command.model;

import lombok.Data;

@Data
public class NotificationInfo {
    private long id;
    private long userId;
    private String message;
    private NotificationType type;
}
