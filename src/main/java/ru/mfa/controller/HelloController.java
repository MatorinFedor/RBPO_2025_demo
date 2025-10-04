package ru.mfa.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import ru.mfa.NotificationService;
import ru.mfa.OrderProcessor;

@RestController
public class HelloController {

    @Value("${greeting.text}")
    private String greetingText;

    @GetMapping("/welcome")
    public OrderProcessor hello() {
        return new OrderProcessor(new NotificationService());
    }

}
