package ru.mfa.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mfa.model.Student;
import ru.mfa.service.StudentService;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<Student> getStudent(
            @RequestParam @Size(min = 3, max = 255) String name) {
        return ResponseEntity
                .ok()
                .body(studentService.getStudent(name));
    }

    @PostMapping
    public ResponseEntity<Student> addStudent(
            @Valid @RequestBody Student student,
            @RequestHeader("X-USER-ID") String id) {
        return ResponseEntity
                .status(CREATED)
                .header("X-USER-ID", student.getEmail())
                .body(studentService.addStudent(student));
    }

    @DeleteMapping("/by-name/{name}")
    public ResponseEntity<Void> removeStudent(
            @PathVariable String name){
        studentService.removeStudent(name);
        return ResponseEntity.noContent().build();
    }
}
