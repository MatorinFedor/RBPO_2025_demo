package ru.mfa.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mfa.entity.CourseEntity;
import ru.mfa.entity.GroupEntity;
import ru.mfa.entity.StudentEntity;
import ru.mfa.model.StudentDto;
import ru.mfa.repository.CourserRepository;
import ru.mfa.repository.GroupRepository;
import ru.mfa.repository.StudentRepository;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final GroupRepository groupRepository;
    private final CourserRepository courserRepository;

    public StudentEntity getStudent(String name) {
        return studentRepository.findByName(name);
    }

    @Transactional
    public StudentEntity addStudent(StudentDto studentDto) {
        GroupEntity group = groupRepository.findByName(studentDto.getGroup());
        CourseEntity course = null;
        if (studentDto.getAdditionalCourse() != null) {
            course = courserRepository.findByName(
                    studentDto.getAdditionalCourse());
        }
        StudentEntity student = new StudentEntity();
        student.setName(studentDto.getName());
        student.setEmail(studentDto.getEmail());
        student.setGroup(group);
        student.setAdditionalCourse(course);
        return studentRepository.save(student);
    }

    @Transactional
    public void removeStudent(String name) {
        studentRepository.deleteByName(name);
    }
}
