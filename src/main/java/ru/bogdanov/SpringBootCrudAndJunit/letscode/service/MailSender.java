package ru.bogdanov.SpringBootCrudAndJunit.letscode.service;

import org.springframework.stereotype.Service;
import ru.bogdanov.SpringBootCrudAndJunit.letscode.model.Message;

@Service
public class MailSender {
    public void send(String emailTo, String subject, String message) {
        Message res = new Message();
        res.setMessage(message);
        res.setEmailTo(emailTo);
        res.setSubject(subject);
        System.out.println(res);
    }
}
