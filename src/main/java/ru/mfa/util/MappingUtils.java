package ru.mfa.util;

import org.springframework.stereotype.Component;
import ru.mfa.entity.CourseEntity;
import ru.mfa.entity.GroupEntity;
import ru.mfa.entity.StudentEntity;
import ru.mfa.model.CourseDto;
import ru.mfa.model.GroupDto;
import ru.mfa.model.StudentDto;

import java.util.ArrayList;
import java.util.List;

@Component
public class MappingUtils {

    public StudentDto toDto(StudentEntity e) {
        StudentDto dto = new StudentDto();
        dto.setName(e.getName());
        dto.setEmail(e.getEmail());
        dto.setGroup(e.getGroup() != null ? e.getGroup().getName() : null); // защита от NPE
        if (e.getAdditionalCourse() != null) {
            dto.setAdditionalCourse(e.getAdditionalCourse().getName());
        }
        return dto;
    }

    public CourseDto toDto(CourseEntity e) {
        CourseDto dto = new CourseDto();
        dto.setName(e.getName());
        dto.setDescription(e.getDescription());
        return dto;
    }

    public GroupDto toDto(GroupEntity e) {
        GroupDto dto = new GroupDto();
        dto.setName(e.getName());
        List<StudentDto> students = new ArrayList<>();
        if (e.getStudents() != null) {
            for (StudentEntity s : e.getStudents()) {
                students.add(toDto(s));
            }
        }
        dto.setStudents(students);

        List<CourseDto> courses = new ArrayList<>();
        if (e.getCourses() != null) {
            for (CourseEntity c : e.getCourses()) {
                courses.add(toDto(c));
            }
        }
        dto.setCourses(courses);
        return dto;
    }

    public StudentEntity toEntity(StudentDto dto, GroupEntity group, CourseEntity additionalCourse) {
        StudentEntity e = new StudentEntity();
        e.setName(dto.getName());
        e.setEmail(dto.getEmail());
        e.setGroup(group);
        e.setAdditionalCourse(additionalCourse);
        return e;
    }
}
