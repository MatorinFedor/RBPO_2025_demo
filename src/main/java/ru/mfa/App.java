package ru.mfa;

public class App {
    public static void main(String[] args) {
        Person p = Person.builder()
                .name("Test")
                .age(21)
                .build();

        System.out.println(p);
    }
}
