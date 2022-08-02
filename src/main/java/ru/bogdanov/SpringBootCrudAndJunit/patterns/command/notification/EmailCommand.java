package ru.bogdanov.SpringBootCrudAndJunit.patterns.command.notification;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.bogdanov.SpringBootCrudAndJunit.patterns.command.model.NotificationInfo;
import ru.bogdanov.SpringBootCrudAndJunit.patterns.command.model.NotificationType;

@Component
@Slf4j
public class EmailCommand implements Command {
    @Override
    public void send(NotificationInfo info) {
        log.info("Email 1 {}", info.getMessage());
        log.info("Email 2 {}", info.getMessage());
        log.info("Email 3 {}", info.getMessage());
        log.info("Email 4 {}", info.getMessage());
        log.info("Email 5 {}", info.getMessage());
        log.info("Email 6 {}", info.getMessage());
        log.info("Email 7 {}", info.getMessage());
        log.info("Email 8 {}", info.getMessage());
    }

    @Override
    public NotificationType getType() {
        return NotificationType.EMAIL;
    }
}
