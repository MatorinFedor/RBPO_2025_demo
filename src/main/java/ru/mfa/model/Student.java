package ru.mfa.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class Student {
    @NotBlank
    private String name;
    @Email
    private String email;
    @Valid
    private Group group;
    @Valid
    private Course addtionalCourse;
}
