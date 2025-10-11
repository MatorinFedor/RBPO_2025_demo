package ru.mfa.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import ru.mfa.OrderProcessor;

@RestController
public class HelloController {

    private final OrderProcessor orderProcessor;

    @Value("${greeting.text}")
    private String greetingText;

    @Value("${greeting.int}")
    private int greetingInt;

    public HelloController(OrderProcessor orderProcessor){
        this.orderProcessor = orderProcessor;
    }

    @GetMapping("/hello")
    public String hello() {
        return greetingText + greetingInt;
    }

}
