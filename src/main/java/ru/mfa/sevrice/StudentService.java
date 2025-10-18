package ru.mfa.sevrice;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mfa.entity.CourseEntity;
import ru.mfa.entity.GroupEntity;
import ru.mfa.entity.StudentEntity;
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

    public StudentEntity addStudent(StudentDto student) {
        GroupEntity group = groupRepository.findByName(student.getGroup());
        CourseEntity course = null;
        if (student.getAdditionalCourse() != null) {
            courseRepository.findByName(student.getAdditionalCourse());
        }
        StudentEntity studentEntity = new  StudentEntity();
        studentEntity.setName(student.getName());
        studentEntity.setEmail(student.getEmail());
        studentEntity.setGroup(group);
        studentEntity.setAdditionalCourse(course);
        return studentRepository.save(studentEntity);
    }

    public StudentEntity getStudent(String name) {
        return studentRepository.findByName(name);
    }

    public void removeStudent(String name) {
        studentRepository.delete(getStudent(name));
    }

}
