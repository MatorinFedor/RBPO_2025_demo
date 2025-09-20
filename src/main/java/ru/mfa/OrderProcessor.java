package ru.mfa;

import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
public class OrderProcessor {
    @Getter
    private final String test = "test";
    private NotificationService notifier;

    public OrderProcessor(NotificationService notifier) {
        this.notifier = notifier;
    }
}
