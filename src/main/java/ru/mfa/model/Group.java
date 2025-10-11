package ru.mfa.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Data
public class Group {
    @NotBlank
    private String name;
    private List<Student> students;
    private List<Course> courses;
}
