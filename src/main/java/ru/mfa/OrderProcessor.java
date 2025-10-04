package ru.mfa;

import org.springframework.stereotype.Component;

@Component
public class OrderProcessor {
    private NotificationService notifier;

    public OrderProcessor(NotificationService notifier) {
        this.notifier = notifier;
    }

    public void setNotifier(NotificationService notifier) {
        this.notifier = notifier;
    }
}
