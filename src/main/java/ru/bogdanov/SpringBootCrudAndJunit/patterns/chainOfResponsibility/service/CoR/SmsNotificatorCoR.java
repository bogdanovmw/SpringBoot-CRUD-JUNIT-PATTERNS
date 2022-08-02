package ru.bogdanov.SpringBootCrudAndJunit.patterns.chainOfResponsibility.service.CoR;

import org.springframework.stereotype.Component;
import ru.bogdanov.SpringBootCrudAndJunit.patterns.chainOfResponsibility.model.Order;
import ru.bogdanov.SpringBootCrudAndJunit.patterns.chainOfResponsibility.service.dop.SmsNotificator;

@Component
public class SmsNotificatorCoR implements ChainOfResponsibility {
    private final SmsNotificator smsNotificator;

    public SmsNotificatorCoR(SmsNotificator smsNotificator) {
        this.smsNotificator = smsNotificator;
    }

    @Override
    public void apply(Order order) {
        if (order.isSmsNotification())
            smsNotificator.enableNotifications(order.getId(), order.getPhoneNumber());
    }
}
