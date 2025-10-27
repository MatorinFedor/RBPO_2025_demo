package ru.mfa.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CourseDto {
    @NotBlank
    private String name;
    private String description;
}
