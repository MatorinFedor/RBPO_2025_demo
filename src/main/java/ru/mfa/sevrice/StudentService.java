package ru.mfa.sevrice;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import ru.mfa.model.Student;

import java.util.HashMap;
import java.util.Map;

@Service
public class StudentService {

    private final Map<String, Student> students = new HashMap<>();

    public Student addStudent(Student student) {
        students.put(student.getName(), student);
        return students.get(student.getName());
    }

    public Student getStudent(String name) {
        return students.get(name);
    }

    public void removeStudent(String name) {
        students.remove(name);
    }

}
