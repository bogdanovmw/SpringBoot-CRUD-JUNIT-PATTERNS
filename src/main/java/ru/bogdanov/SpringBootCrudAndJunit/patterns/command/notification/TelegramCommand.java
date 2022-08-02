package ru.bogdanov.SpringBootCrudAndJunit.patterns.command.notification;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.bogdanov.SpringBootCrudAndJunit.patterns.command.model.NotificationInfo;
import ru.bogdanov.SpringBootCrudAndJunit.patterns.command.model.NotificationType;

@Component
@Slf4j
public class TelegramCommand implements Command {
    @Override
    public void send(NotificationInfo info) {
        log.info("TELEGRAM 1 {}", info.getMessage());
        log.info("TELEGRAM 2 {}", info.getMessage());
        log.info("TELEGRAM 3 {}", info.getMessage());
        log.info("TELEGRAM 4 {}", info.getMessage());
        log.info("TELEGRAM 5 {}", info.getMessage());
        log.info("TELEGRAM 6 {}", info.getMessage());
        log.info("TELEGRAM 7 {}", info.getMessage());
        log.info("TELEGRAM 8 {}", info.getMessage());
    }

    @Override
    public NotificationType getType() {
        return NotificationType.TELEGRAM;
    }
}
