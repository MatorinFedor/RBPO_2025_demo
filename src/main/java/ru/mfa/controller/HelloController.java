package ru.mfa.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${greeting.text}")
    private String greetingText;

    @Value("${greeting.int}")
    private int greetingInt;

    @GetMapping("/hello")
    public String hello() {
        return greetingText + greetingInt;
    }

}
