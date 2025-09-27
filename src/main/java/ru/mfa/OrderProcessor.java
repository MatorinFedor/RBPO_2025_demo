package ru.mfa;

import org.springframework.stereotype.Component;

@Component
public class OrderProcessor {
    private final NotificationService notifier;

    public OrderProcessor(NotificationService notifier) {
        this.notifier = notifier;
    }

}
