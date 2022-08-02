package ru.bogdanov.SpringBootCrudAndJunit.patterns.chainOfResponsibility.service.dop;

import org.springframework.stereotype.Component;

@Component
public class SmsNotificator {
    public void enableNotifications(String orderId, String phoneNumber) {
        System.out.println("Enable sms notifications order: " + orderId + " by phone: " + phoneNumber);
    }
}
