package ru.mfa.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mfa.OrderProcessor;

@RestController
public class HelloController {

    private final OrderProcessor processor;

    public HelloController(OrderProcessor processor) {
        this.processor = processor;
    }

    @Value("${greeting.text}")
    private String greetingText;

    @Value("${greeting.int}")
    private String greetingInt;

    @GetMapping("/hello")
    public String hello() {
        return greetingText + greetingInt + processor;
    }

}
