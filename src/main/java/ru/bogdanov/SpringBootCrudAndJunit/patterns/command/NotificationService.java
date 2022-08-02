package ru.bogdanov.SpringBootCrudAndJunit.patterns.command;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.bogdanov.SpringBootCrudAndJunit.patterns.command.model.NotificationInfo;
import ru.bogdanov.SpringBootCrudAndJunit.patterns.command.model.NotificationType;
import ru.bogdanov.SpringBootCrudAndJunit.patterns.command.notification.Command;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@Slf4j
public class NotificationService {
    private final Map<NotificationType, Command> notificationMap;

    public NotificationService(List<Command> list) {
        // { NotificationType.SMS, SmsCommand }
        // { NotificationType.EMAIL, EmailCommand }
        // { NotificationType.TELEGRAM, TelegramCommand }
        this.notificationMap = list.stream().collect(Collectors.toMap(Command::getType, Function.identity()));
    }

    public void send(NotificationInfo info) {
        Command command = notificationMap.get(info.getType());
        command.send(info);
    }
}
