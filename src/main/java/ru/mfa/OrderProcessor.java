package ru.mfa;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class OrderProcessor {
    @Qualifier("mail_notification")
    private NotificationService notificationService;

    public OrderProcessor(NotificationService service) {
        this.notificationService = service;
    }
}
