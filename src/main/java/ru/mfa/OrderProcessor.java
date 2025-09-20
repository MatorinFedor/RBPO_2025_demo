package ru.mfa;

import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
public class OrderProcessor {
    @Getter
    private final String test = "test";
    private final NotificationService notificationService;

    public OrderProcessor(
            NotificationService notificationService) {
        this.notificationService = notificationService;
    }

}
