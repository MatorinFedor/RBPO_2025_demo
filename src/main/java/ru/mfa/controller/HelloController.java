package ru.mfa.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @Value("${greeting.text}")
    private String greetingText;

    @Value("${greeting.int1}")
    private int num;

    @GetMapping("/welcome")
    public String hello() {
        return greetingText + num;
    }
}
