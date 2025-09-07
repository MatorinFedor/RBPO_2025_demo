package ru.mfa;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class Person {
    private final String name;
    private final int age;
}
