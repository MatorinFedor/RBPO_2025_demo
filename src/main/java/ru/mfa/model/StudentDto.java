package ru.mfa.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class StudentDto {
    @NotBlank
    @Size(max = 255, min = 3)
    private String name;
    @Email
    private String email;

    private String group;

    private String additionalCourse;
}
