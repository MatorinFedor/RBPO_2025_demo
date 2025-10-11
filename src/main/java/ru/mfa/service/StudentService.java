package ru.mfa.service;

import org.springframework.stereotype.Service;
import ru.mfa.model.Student;

import java.util.HashMap;
import java.util.Map;

@Service
public class StudentService {

    private final Map<String, Student> students = new HashMap<>();

    public Student getStudent(String name) {
        return students.get(name);
    }

    public Student addStudent(Student student) {
        students.put(student.getName(), student);
        return students.get(student.getName());
    }

    public void removeStudent(String name) {
        students.remove(name);
    }
}
