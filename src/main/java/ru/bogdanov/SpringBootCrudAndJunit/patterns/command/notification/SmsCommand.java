package ru.bogdanov.SpringBootCrudAndJunit.patterns.command.notification;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.bogdanov.SpringBootCrudAndJunit.patterns.command.model.NotificationInfo;
import ru.bogdanov.SpringBootCrudAndJunit.patterns.command.model.NotificationType;

@Component
@Slf4j
public class SmsCommand implements Command {
    @Override
    public void send(NotificationInfo info) {
        log.info("SMS 1 {}", info.getMessage());
        log.info("SMS 2 {}", info.getMessage());
        log.info("SMS 3 {}", info.getMessage());
        log.info("SMS 4 {}", info.getMessage());
        log.info("SMS 5 {}", info.getMessage());
        log.info("SMS 6 {}", info.getMessage());
        log.info("SMS 7 {}", info.getMessage());
        log.info("SMS 8 {}", info.getMessage());
    }

    @Override
    public NotificationType getType() {
        return NotificationType.SMS;
    }
}
