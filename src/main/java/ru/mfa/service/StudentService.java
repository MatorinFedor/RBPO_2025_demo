package ru.mfa.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mfa.entities.CourseEntity;
import ru.mfa.entities.GroupEntity;
import ru.mfa.entities.StudentEntity;
import ru.mfa.model.StudentDto;
import ru.mfa.repository.CourseRepository;
import ru.mfa.repository.GroupRepository;
import ru.mfa.repository.StudentRepository;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final GroupRepository groupRepository;
    private final CourseRepository courseRepository;

    public StudentEntity getStudent(String name) {
        return studentRepository.findByName(name);
    }

    @Transactional
    public StudentEntity addStudent(StudentDto studentDto) {
        GroupEntity group = groupRepository.findByName(studentDto.getGroup());
        CourseEntity course = courseRepository.findByName(studentDto.getAdditionalCourse());

        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setName(studentDto.getName());
        studentEntity.setEmail(studentDto.getEmail());
        studentEntity.setGroup(group);
        studentEntity.setAdditionalCourse(course);

        return studentRepository.save(studentEntity);
    }

    @Transactional
    public void removeStudent(String name) {
        studentRepository.deleteByName(name);
    }
}
