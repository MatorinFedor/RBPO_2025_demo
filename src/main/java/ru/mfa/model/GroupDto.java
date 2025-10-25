package ru.mfa.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Data
public class GroupDto {
    @NotBlank
    private String name;
    private List<StudentDto> studentDtos;
    private List<CourseDto> cours;
}
