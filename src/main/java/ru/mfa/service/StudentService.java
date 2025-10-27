package ru.mfa.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mfa.entity.CourseEntity;
import ru.mfa.entity.GroupEntity;
import ru.mfa.entity.StudentEntity;
import ru.mfa.model.StudentDto;
import ru.mfa.repository.StudentRepository;
import ru.mfa.util.MappingUtils;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final GroupService groupService;
    private final CourseService courseService;
    private final StudentRepository studentRepository;
    private final MappingUtils mapping;

    public StudentEntity getStudent(String name) {
        return studentRepository.findByName(name);
    }

    @Transactional
    public StudentEntity addStudent(StudentDto dto) {
        GroupEntity group = groupService.findByName(dto.getGroup());
        CourseEntity course = null;
        if (dto.getAdditionalCourse() != null || !dto.getAdditionalCourse().isBlank()) {
            course = courseService.findByName(dto.getAdditionalCourse());
        }
        StudentEntity entity = mapping.toEntity(dto, group, course);
        return studentRepository.save(entity);
    }

    @Transactional
    public void removeStudent(String name) {
        studentRepository.deleteByName(name);
    }

}
