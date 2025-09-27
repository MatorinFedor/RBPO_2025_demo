package ru.mfa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderProcessor {
    private NotificationService notifier;

    public OrderProcessor(NotificationService notifier) {
        this.notifier = notifier;
    }

    @Autowired
    public void setNotifier(NotificationService notifier) {
        this.notifier = notifier;
    }
}
