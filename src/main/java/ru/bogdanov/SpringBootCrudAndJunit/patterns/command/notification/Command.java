package ru.bogdanov.SpringBootCrudAndJunit.patterns.command.notification;

import ru.bogdanov.SpringBootCrudAndJunit.patterns.command.model.NotificationInfo;
import ru.bogdanov.SpringBootCrudAndJunit.patterns.command.model.NotificationType;

public interface Command {
    void send(NotificationInfo info);
    NotificationType getType();
}
