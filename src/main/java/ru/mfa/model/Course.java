package ru.mfa.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class Course {
    @NotBlank
    private String name;
    private String description;
}
