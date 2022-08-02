package ru.bogdanov.SpringBootCrudAndJunit.patterns.command;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.bogdanov.SpringBootCrudAndJunit.patterns.command.model.NotificationInfo;

@RestController("/command")
public class NotificationController {
    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping
    public void send(@RequestBody NotificationInfo info) {
        notificationService.send(info);
    }
}
