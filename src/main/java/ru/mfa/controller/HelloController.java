package ru.mfa.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import ru.mfa.OrderProcessor;

@RestController
public class HelloController {

    private final OrderProcessor processor;

    public HelloController(OrderProcessor processor) {
        this.processor = processor;
    }

    @Value("${greeting.text}")
    private String greetingText;

    @GetMapping("/welcome")
    public OrderProcessor hello() {
        return processor;
    }

}
